package ai.szs.szsapi.db.specification;

import ai.szs.szsapi.db.domain.File;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class FileSpecification {

    public static Specification<File> equalFileType(String fileType) {
        return new Specification<File>() {
            @Override
            public Predicate toPredicate(Root<File> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("fileType"), fileType);
            }
        };
    }

    public static Specification<File> inFileUploadType(List<String> fileUploadType) {
        return new Specification<File>() {
            @Override
            public Predicate toPredicate(Root<File> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return root.get("fileUploadType").in(fileUploadType);
            }
        };
    }

    public static Specification<File> equalTargetType(String targetType) {
        return new Specification<File>() {
            @Override
            public Predicate toPredicate(Root<File> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("targetType"), targetType);
            }
        };
    }

    public static Specification<File> equalFileName(String fIdx) {
        return new Specification<File>() {
            @Override
            public Predicate toPredicate(Root<File> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("fIdx"), fIdx);
            }
        };
    }

}
