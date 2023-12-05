package christmas.util.Mapper;

import christmas.domain.EventType;
import christmas.domain.event.DiscountRecord;
import christmas.dto.response.DiscountResponse;

import java.util.HashMap;
import java.util.Map;

public class DiscountResponseMapper {

    public static DiscountResponse of(DiscountRecord discountRecord){
        Map<String, Integer> result = new HashMap<>();
        for(EventType eventType:EventType.values()){
            if(discountRecord.isExistSpecificEventDiscount(eventType)){
                result.put(eventType.getEventName(),discountRecord.getDiscountAmount(eventType));
            }
        }
        return new DiscountResponse(result);
    }

    public static DiscountResponse of (){
        Map<String, Integer> result = new HashMap<>();
        return new DiscountResponse(result);
    }
}
