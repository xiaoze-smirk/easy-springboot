package xiao.ze.demo.entity;

import org.springframework.stereotype.Component;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */

public class CourseType extends ValueObject{


    private Integer typeId;
    private String  typeName;


    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @Override
    public String toString() {
        return "CourseType [typeId=" + typeId + ", typeName=" + typeName + "]";
    }

}
