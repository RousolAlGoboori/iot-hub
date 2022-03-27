package com.cs490.iothub.service;

import com.cs490.iothub.annotation.DateField;
import com.cs490.iothub.model.*;
import com.cs490.iothub.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:A class which implements the ProductService interface with @Service annotation
 *  and write the business logic to store, retrieve, delete and updates the product.
 */

@Service
public class UIService {

    @Autowired
    ThingRepository thingRepository;

    @Autowired
    DataItemRepository dataItemRepository;

    @Autowired
    VirtualSpaceRepository virtualSpaceRepository;

    @Autowired
    QueryRepository queryRepository;

    List<Alarm> alarmList = new ArrayList<>();
    List<String> allColumnNames = new ArrayList<>();
    String tableName = "";

    public String createThing(Thing thing) {
        thingRepository.save(thing);
        return thing.getName() + " has been created.";
    }
    public String createDataItem(DataItem dataItem) {
        dataItemRepository.save(dataItem);
        return dataItem.getName() + " has been created.";
    }

    public String checkForMatchingAlarm(String scope, String conditionValue) {
    String f = null;
        Set<String> conditionValues = alarmList.stream().filter(alarm -> alarm.getScope().equals(scope))
                .map(alarm -> alarm.getConditions().split("::")[2]).collect(Collectors.toSet());
        if (conditionValues.contains(conditionValue)&& Objects.equals(scope, "TH")) {
            f = "Finally the new Thing " + conditionValue + " match your alarm";
        }
        else if (conditionValues.contains(conditionValue)&& Objects.equals(scope, "DT"))
        {
            f = "Finally the new DataItem " + conditionValue + " match your alarm";
        }
        return f;
    }

    public List<String> getThings() {

        List<String> thingsList = new ArrayList<>();

        thingRepository.findAll().iterator().forEachRemaining(thing -> {
            String thingsString = "Name:   " + thing.getName() + "\n" +
                    "IP Address:   " + thing.getIPAddress() + "\n" +
                    "Active:   " + thing.getActive() + "\n" +
                    "VirtualSpaces:   " + thing.getvSpacesThing() + "\n" +
                    "Created:   " + thing.getCreatedT() + "\n" +
                    "Modified:   " + thing.getModifiedT() + "\n" +
                    "Requested:   " + thing.getRequestedT() + "\n" +
                    "Subscribed:   " + thing.getSubscribedT() + "\n";
            thingsList.add(thingsString);
        });
        return thingsList;
    }

    public List<Thing> getAllThing() {

        // findAll() : It will retrieve all records saved into DB
        List<Thing> thingList = thingRepository.findAll();
        thingList.forEach(System.out::println);     // Printing all saved things
        return thingList;
    }

    public List<DataItem> getAllDataItem() {

        // findAll() : It will retrieve all records saved into DB
        List<DataItem> dataItemList = dataItemRepository.findAll();
        //dataItemList.forEach(System.out::println);     // Printing all saved things
        return dataItemList;
    }


    public Thing getThingById(String id) {
        //"6182fdf2b0ce190700dcbc5a" testing id
        Optional<Thing> opt = thingRepository.findById(id);
        System.out.println("Here is the thing details : " + opt.get().toString());

        return opt.get();
    }
    public Set<String> getAvailableThingsNames() {

        Set<String> availableThingsNames = new HashSet<>();
        thingRepository.findAll().iterator().forEachRemaining(thing -> {
            availableThingsNames.add("ThingId:  " + thing.getThingId() + ",        Name:  " + thing.getName());
        });
        return availableThingsNames;
    }

    public List<String> getDataItems() {

        List<String> dataItemsList = new ArrayList<>();
        dataItemRepository.findAll().iterator().forEachRemaining(dataItem -> {
            String dataItemString = "Name:   " + dataItem.getName() + "\n" +
                    "Creator:   " + dataItem.getCreator() + "\n" +
                    "Access:   " + dataItem.getAccess() + "\n" +
                    "VirtualSpaces:   " + dataItem.getvSpaceDataItem() + "\n" +
                    "Modifiers:   " + dataItem.getModifiersD() + "\n" +
                    "Requester:   " + dataItem.getRequesterD() + "\n" +
                    "Subscriber:   " + dataItem.getSubscriberD() + "\n" +
                    "CreatedAt:   " + dataItem.getCreatedAtD() + "\n" +
                    "ModifiedAt:   " + dataItem.getModifiedBD() + "\n" +
                    "AccessFrequency:   " + dataItem.getAccessFrequencyD() + "\n" +
                    "ModificationFrequency:   " + dataItem.getModificationFrequencyD() + "\n" +
                    "Expired():   " + dataItem.getExpired() + "\n" +
                    "Format:   " + dataItem.getFormat() + "\n" +
                    "TypeDomain:   " + dataItem.getTypeDomain() + "\n" +
                    "ApplicationDomain:   " + dataItem.getApplicationDomain() + "\n" +
                    "Payload:   " + dataItem.getPayload() + "\n" +
                    "AccumulatedPayload:   " + dataItem.getAccumulatedPayload() + "\n";
            dataItemsList.add(dataItemString);
        });
        return dataItemsList;
    }

    public Set<String> getAvailableDataItemsNames() {

        Set<String> availableDataItemsNames = new HashSet<>();
        dataItemRepository.findAll().iterator().forEachRemaining(dataItem -> {
            availableDataItemsNames.add("DataItemId:  " + dataItem.getItemId() + ",        Name:  " + dataItem.getName());
        });
        return availableDataItemsNames;
    }
    public List<Alarm> createAlarm(Alarm request) {
        Alarm alarm = new Alarm();
        alarm.setScope(request.getScope());
        alarm.setConditions(request.getConditions());
        alarmList.add(alarm);
        //alarmRepository.save(alarm);
       return alarmList;
    }
    public List<String> getAlarms() {
        Alarm alarm = new Alarm();
        List<String> alarmList = new ArrayList<>();
        //retrieve alarm data to display on frontend
            String resultString = "Scope:  " + alarm.getScope() + "\n" +
                    "Conditions:  " + alarm.getConditions()+ "\n" ;

            alarmList.add(resultString);

        return alarmList;

    }

    public List<String> createVirtualSpace(VirtualSpace request) {

        //create new virtualSpace object with only thingIds and dataItemIds
        VirtualSpace virtualSpace = new VirtualSpace();
        virtualSpace.setDescription(request.getDescription());
        virtualSpace.setType(request.getType());
        virtualSpace.setSelectedThings(getId(request.getSelectedThings()));
        virtualSpace.setSelectedDataItems(getId(request.getSelectedDataItems()));
        virtualSpace.setCreatedAt(Instant.now());

        //save created virtual data in db
        virtualSpaceRepository.save(virtualSpace);
        return getAllVirtualSpaces();
    }

    public List<String> getAllVirtualSpaces() {

        List<String> virtualSpacesList = new ArrayList<>();
        //retrieve virtual space data to display on frontend
        virtualSpaceRepository.findAll().iterator().forEachRemaining(space -> {
            String resultString = "Virtual Space Id:  " + space.getVirtualSpaceId() + "\n" +
                    "Description:  " + space.getDescription() + "\n" +
                    "Space Type:  " + space.getType() + "\n" +
                    "Things:  " + Arrays.toString(space.getSelectedThings()) + "\n" +
                    "Data Items:  " + Arrays.toString(space.getSelectedDataItems()) + "\n" +
                    "CreatedAt:  " + space.getCreatedAt() + "\n";
            virtualSpacesList.add(resultString);
        });
        return virtualSpacesList;
    }

    private String[] getId(String[] values) {
        Object[] idList = Arrays.stream(values).map(value -> {
            return value.split(",")[0].split(":")[1].trim();
        }).toArray();
        return Arrays.copyOf(idList, idList.length, String[].class);
    }

    public Collection getQueryResult(QueryStructure queryStructure) throws JsonProcessingException {

        String inputScope = queryStructure.getScope();
        String scope = inputScope.substring(inputScope.indexOf("/") + 1, inputScope.lastIndexOf("/"));
        String[] scopeLiterals = scope.split("/");

        List<ScopeData> scopeDataList = Arrays.stream(scopeLiterals).map(literal -> {
            String symbol = literal.split(":")[0];
            List<String> scopeValues = Arrays.asList(literal.split(":")[1].split(","));
            return new ScopeData(symbol, scopeValues);
        }).collect(Collectors.toList());

        List<String> returnAttributes = Collections.emptyList();
        if(queryStructure.getReturnAttributes() != null && !Objects.equals(queryStructure.getReturnAttributes(), "")) {
            returnAttributes = Arrays.asList(queryStructure.getReturnAttributes().split(","));
        }
        //if multiple values then split with "," else no split
        List<Condition> conditions = Collections.emptyList();
        if(queryStructure.getConditions() != null && !Objects.equals(queryStructure.getConditions(), "")) {
            conditions = Arrays.asList(queryStructure.getConditions().split(",")).stream()
                    .map(condition -> {
                        String[] literals = condition.split("::");
                        return new Condition(literals[0], literals[1], literals[2]);
                    }).collect(Collectors.toList());
        }

        return queryBuilder(scopeDataList, conditions, returnAttributes);
    }

    private Collection queryBuilder(List<ScopeData> scopeDataList, List<Condition> conditions,
                                    List<String> returnAttributes) throws JsonProcessingException {

        String tableName = ScopeKeywords.fromString(scopeDataList.get(0).getSymbol());
        Query query = null;

        switch (Objects.requireNonNull(tableName)) {
            case "thing":
                if (scopeDataList.get(0).getScopeValues().contains("*")) {
                    query = buildQuery(null, conditions, returnAttributes);
                } else {
                    query = buildQuery(scopeDataList, conditions, returnAttributes);
                }
                setTableName(tableName);
                setAllColumnNames(tableName);
                if(query == null) {
                    return queryRepository.getAllThings();
                } else {
                    return queryRepository.getThings(query);
                }

            case "dataItem":
                if (scopeDataList.get(0).getScopeValues().contains("*")) {
                    query = buildQuery(null, conditions, returnAttributes);
                } else {
                    query = buildQuery(scopeDataList, conditions, returnAttributes);
                }
                setTableName(tableName);
                setAllColumnNames(tableName);
                if(query == null) {
                    return queryRepository.getAllDataItems();
                } else {
                    return queryRepository.getDataItems(query);
                }
            case "virtualSpace":
                  query = buildQuery(scopeDataList, conditions, returnAttributes);

                if (scopeDataList.get(1).getSymbol().equals("TH")) {
                    setTableName(ScopeKeywords.TH.getTableName());
                    setAllColumnNames(ScopeKeywords.TH.getTableName());
                    if(query == null) {
                        return queryRepository.getAllThings();
                    } else {
                        return queryRepository.getThings(query);
                    }
                } else {
                    setTableName(ScopeKeywords.DT.getTableName());
                    setAllColumnNames(ScopeKeywords.DT.getTableName());
                    if(query == null) {
                        return queryRepository.getAllDataItems();
                    } else {
                        return queryRepository.getDataItems(query);
                    }
                }
            default:
                break;
        }
        return Collections.singletonList("");
    }

    private Query buildQuery(List<ScopeData> scopeDataList, List<Condition> conditions,
                             List<String> returnAttributes) throws JsonProcessingException {

        // build query with given conditions example: { name : { $eq : \"thing2\" } };
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode conditionNode = mapper.createObjectNode();
        ObjectNode dateConditionNode = mapper.createObjectNode();
        Query query = null;

        if (conditions != null) {
            conditions.forEach(condition -> {
                ObjectNode value = mapper.createObjectNode();
                if (isDateField(condition.getColumnName())) {
                    dateConditionNode.put("$date", condition.getValue().trim());
                    value.put("$" + condition.getOperator().trim(), dateConditionNode);
                } else {
                    value.put("$" + condition.getOperator().trim(), condition.getValue().trim());
                }
                conditionNode.put(condition.getColumnName().trim(), value);
            });
        }
        if (scopeDataList != null) {
            ObjectNode value = mapper.createObjectNode();
            if (scopeDataList.get(0).getSymbol().equals(ScopeKeywords.TH.name())) {
            Set<String> thingIds = new HashSet<>(scopeDataList.get(0).getScopeValues());
                query = new Query(Criteria.where("thingId").in(thingIds));

            } else if (scopeDataList.get(0).getSymbol().equals(ScopeKeywords.DT.name())) {
                Set<String> itemIds = new HashSet<>(scopeDataList.get(0).getScopeValues());
                query = new Query(Criteria.where("itemId").in(itemIds));

            } else if (scopeDataList.get(0).getSymbol().equals(ScopeKeywords.VS.name())) {  //need to review logic

                if (scopeDataList.get(1).getSymbol().equals("TH")) {

                    if (scopeDataList.get(1).getScopeValues().contains("*")) {
                        VirtualSpace virtualSpace = virtualSpaceRepository.
                                findById(scopeDataList.get(0).getScopeValues().get(0)).orElseThrow( () -> new NotFoundException("virtual space not found"));
                        Set<String> thingIds = Arrays.stream(virtualSpace.getSelectedThings()).collect(Collectors.toSet());
                        query = new Query(Criteria.where("thingId").in(thingIds));

                    } else {
                        query = new Query(Criteria.where("thingId").in(scopeDataList.get(1).getScopeValues()));
                    }

                } else if (scopeDataList.get(1).getSymbol().equals("DT")) {

                    if (scopeDataList.get(1).getScopeValues().contains("*")) {
                        VirtualSpace virtualSpace = virtualSpaceRepository.
                                findById(scopeDataList.get(0).getScopeValues().get(0)).orElseThrow( () -> new NotFoundException("virtual space not found"));
                        Set<String> itemIds = Arrays.stream(virtualSpace.getSelectedDataItems()).collect(Collectors.toSet());
                        query = new Query(Criteria.where("itemId").in(itemIds));

                    } else {
                        query = new Query(Criteria.where("itemId").in(scopeDataList.get(1).getScopeValues()));
                    }
                }
            }
        }
       if (query == null && conditionNode != null) {
           query = new BasicQuery(new ObjectMapper().writeValueAsString(conditionNode));
       }
        //include specific attributes/return fields as requested by the user
        Query finalQuery = query;
        Query finalQuery1 = finalQuery;
        returnAttributes.forEach(field -> {
            assert finalQuery1 != null;
            finalQuery1.fields().include(field);
        });
        System.out.println("finalQuery:"+ finalQuery);
        assert conditions != null;
        if(conditions.size() == 0 && returnAttributes.size() == 0) {
            finalQuery = null;
        }
        return finalQuery;
    }
    private Boolean isDateField(String fieldName) {

        Set<String> dateFields = getAllFields().stream().filter(field -> field.isAnnotationPresent(DateField.class))
                .map(Field::getName)
                .collect(Collectors.toSet());
        return dateFields.contains(fieldName);
    }

    private Set<Field> getAllFields() {
      return Stream.of(Thing.class.getDeclaredFields(), DataItem.class.getDeclaredFields(), VirtualSpace.class.getDeclaredFields())
                .map(Arrays::asList).flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private void setAllColumnNames(String tableName) {
        if(tableName.equals(ScopeKeywords.TH.getTableName())) {
            allColumnNames = Stream.of(Thing.class.getDeclaredFields())
                    .map(Arrays::asList).flatMap(Collection::stream)
                    .map(Field::getName)
                    .collect(Collectors.toList());
        } else {
            allColumnNames = Stream.of(DataItem.class.getDeclaredFields())
                    .map(Arrays::asList).flatMap(Collection::stream)
                    .map(Field::getName)
                    .collect(Collectors.toList());
        }


    }

    public List<String> getAllColumnNames() {
        return allColumnNames;
    }

    private void setTableName(String resolvedTableName) {
        tableName = resolvedTableName;
    }

    public String getTableName() {
        return tableName;
    }

    public List<String> resolveResult(Collection result, List<String> columns) {
        List<String> resultArray = new ArrayList<>(Collections.emptyList());

            if (Objects.equals(getTableName(), ScopeKeywords.TH.getTableName())) {
                List<Thing> thingList = result.stream().map(obj -> (Thing) obj).toList();

                thingList.forEach(thing -> {
                    StringBuilder thingString = new StringBuilder();
                    columns.forEach(column -> {
                        try {
                            Field field = Thing.class.getDeclaredField(column);
                            field.setAccessible(true);
                            String value = (String) field.get(thing);
                            thingString.append(column).append(": ").append(value).append("\n");
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    });
                    resultArray.add(thingString.toString());
                });
            }
            if (Objects.equals(getTableName(), ScopeKeywords.DT.getTableName())) {
                List<DataItem> dataItemList = result.stream().map(obj -> (DataItem) obj).toList();

                dataItemList.forEach(dataItem -> {
                    StringBuilder dataItemString = new StringBuilder();
                    columns.forEach(column -> {
                        try {
                            Field field = DataItem.class.getDeclaredField(column);
                            field.setAccessible(true);
                            //get dataItem Arraylist Field type values
                            String value = "";
                            if (field.getGenericType().getTypeName().equals("java.util.List<java.lang.String>")){
                                Object object =  field.get(dataItem);
                                if (object != null) {
                                    List<String> valueList = new ObjectMapper().convertValue(object, new TypeReference<List<String>>() {
                                    });
                                    for (String v : valueList) {
                                        value = value + v;
                                    }
                                } else {
                                    value = null;
                                }
                            }
                            else {
                                value = (String) field.get(dataItem);
                            }
                            dataItemString.append(column).append(": ").append(value).append("\n");

                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    });
                    resultArray.add(dataItemString.toString());
                });
            }
        return resultArray;
    }

}

