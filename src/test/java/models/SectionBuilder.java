package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SectionBuilder {
    private String name;
    private int suite_id;
}
