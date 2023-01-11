package ai.szs.szsapi.db.specification;

import ai.szs.szsapi.db.domain.Keyword;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class KeywordSpecification {


    public static Specification<Keyword> equalTargetType(String targetType) {
        return new Specification<Keyword>() {
            @Override
            public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("targetType"), targetType);
            }
        };
    }

    public static Specification<Keyword> equalFieldType(String fieldType) {
        return new Specification<Keyword>() {
            @Override
            public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("분야"), fieldType);
            }
        };
    }


    public static Specification<Keyword> equalIndustryType(String industryType) {
        return new Specification<Keyword>() {
            @Override
            public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("산업"), industryType);
            }
        };
    }

    public static Specification<Keyword> equalItemName(String itemName) {
        return new Specification<Keyword>() {
            @Override
            public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("품목"), itemName);
            }
        };
    }

    public static Specification<Keyword> equalGVCCD(String GVCCD) {
        return new Specification<Keyword>() {
            @Override
            public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("GVCCD"), GVCCD);
            }
        };
    }

    public static Specification<Keyword> like품목개요(String totalSearch) {
        return new Specification<Keyword>() {
            @Override
            public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("품목개요"), totalSearch);
            }
        };
    }

    public static Specification<Keyword> likeKeyword(String totalSearch) {
        return new Specification<Keyword>() {
            @Override
            public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("keyword"), totalSearch);
            }
        };
    }

}
