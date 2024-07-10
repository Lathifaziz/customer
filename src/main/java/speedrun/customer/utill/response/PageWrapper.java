package speedrun.customer.utill.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PageWrapper <T> {
    private List<T> content;
    private long totalElements;
    private Integer totalPages;
    private Integer page;
    private Integer size;

    public PageWrapper(Page<T> page){
        this.content = page.getContent();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.page = page.getNumber();
        this.size = page.getSize();
    }
}