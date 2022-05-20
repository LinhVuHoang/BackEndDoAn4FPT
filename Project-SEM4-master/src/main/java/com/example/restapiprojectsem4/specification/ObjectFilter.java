package com.example.restapiprojectsem4.specification;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class ObjectFilter {
    public static final String FROM = "from";
    public static final String TO = "to";
    public static final String ID = "id";
    public static final String PRICE = "price";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String DETAIL = "detail";
    public static final String CREATED_AT = "createdAt";
    public static final String STATUS = "status";

    private int id;
    private int categoryId;
    private double minPrice;
    private double maxPrice;
    private int page;
    private int pageSize;
    private String name;
    private String status;
    private String detail;
    private String nameProduct;
    private String email;
    private String phone;
    private String from;
    private String to;
    private HashMap<String,String> mapField;


    public static final class ObjectFilterBuilder {
        private int id;
        private int categoryId;
        private double minPrice;
        private double maxPrice;
        private int page;
        private int pageSize;
        private String name;
        private String status;
        private String detail;
        private String nameProduct;
        private String email;
        private String phone;
        private String from;
        private String to;
        private HashMap<String,String> mapField;

        private ObjectFilterBuilder() {
        }

        public static ObjectFilterBuilder anObjectFilter() {
            return new ObjectFilterBuilder();
        }

        public ObjectFilterBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ObjectFilterBuilder withCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ObjectFilterBuilder withMinPrice(double minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public ObjectFilterBuilder withMaxPrice(double maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public ObjectFilterBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public ObjectFilterBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ObjectFilterBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ObjectFilterBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public ObjectFilterBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ObjectFilterBuilder withNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;
            return this;
        }

        public ObjectFilterBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ObjectFilterBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public ObjectFilterBuilder withFrom(String from) {
            this.from = from;
            return this;
        }

        public ObjectFilterBuilder withTo(String to) {
            this.to = to;
            return this;
        }

        public ObjectFilterBuilder withMapField(HashMap<String, String> mapField) {
            this.mapField = mapField;
            return this;
        }

        public ObjectFilter build() {
            ObjectFilter objectFilter = new ObjectFilter();
            objectFilter.maxPrice = this.maxPrice;
            objectFilter.name = this.name;
            objectFilter.mapField = this.mapField;
            objectFilter.page = this.page;
            objectFilter.pageSize = this.pageSize;
            objectFilter.status = this.status;
            objectFilter.email = this.email;
            objectFilter.phone = this.phone;
            objectFilter.id = this.id;
            objectFilter.categoryId = this.categoryId;
            objectFilter.detail = this.detail;
            objectFilter.minPrice = this.minPrice;
            objectFilter.nameProduct = this.nameProduct;
            objectFilter.from = this.from;
            objectFilter.to = this.to;
            return objectFilter;
        }
    }
}
