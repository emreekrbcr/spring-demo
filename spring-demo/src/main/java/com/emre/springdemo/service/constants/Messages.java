package com.emre.springdemo.service.constants;

public class Messages {
	public static class ProductMessages
    {
        public static class SuccessMessages
        {
            public static final String ProductsListed = "Products was listed";
            public static final String ProductListed = "Product was listed";
            public static final String ProductAdded = "Product was added";
            public static final String ProductUpdated = "Product was updated";
            public static final String ProductDeleted = "Product was deleted";

            public static final String ProductDetailsListed = "Product details was listed";
            public static final String ProductDetailListed = "Product detail was listed";
        }

        public static class ErrorMessages
        {
            public static final String CategoryLimitExceeded = "Product counts can not exceed 10 in a category";
            public static final String ProductNameAlreadyExists = "Product name already exists";
            public static final String TotalCategoryCountExceeded =
                "You can not add product because total category count is exceeded";
        }
    }

    public static class CategoryMessages
    {
        public static class SuccessMessages
        {
            public static final String CategoriesListed = "Categories was listed";
        }

        public static class ErrorMessages
        {
        }
    }

}
