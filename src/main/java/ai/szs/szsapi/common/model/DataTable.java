package ai.szs.szsapi.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataTable<T> {

    private int draw;
    private int start;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;
}
