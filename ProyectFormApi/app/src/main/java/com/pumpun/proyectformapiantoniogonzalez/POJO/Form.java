package com.pumpun.proyectformapiantoniogonzalez.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Form {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("response")
    @Expose
    public Response response;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }


public class Button {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

public class Field {

    @SerializedName("gsurveyLikertRows")
    @Expose
    private List<GsurveyLikertRow> gsurveyLikertRows = null;
    @SerializedName("choices")
    @Expose
    private List<Choice> choices = null;

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("label")
    @Expose
    public String label;
    @SerializedName("adminLabel")
    @Expose
    private String adminLabel;
    @SerializedName("isRequired")
    @Expose
    private Boolean isRequired;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("inputs")
    @Expose
    private Object inputs;
    @SerializedName("enableChoiceValue")
    @Expose
    private Boolean enableChoiceValue;
    @SerializedName("enablePrice")
    @Expose
    private Boolean enablePrice;
    @SerializedName("gsurveyLikertEnableMultipleRows")
    @Expose
    private Boolean gsurveyLikertEnableMultipleRows;
    @SerializedName("gsurveyLikertEnableScoring")
    @Expose
    private Boolean gsurveyLikertEnableScoring;
    @SerializedName("inputType")
    @Expose
    public String inputType;
    @SerializedName("formId")
    @Expose
    private Integer formId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("allowsPrepopulate")
    @Expose
    private Boolean allowsPrepopulate;
    @SerializedName("inputMask")
    @Expose
    private Boolean inputMask;
    @SerializedName("inputMaskValue")
    @Expose
    private String inputMaskValue;
    @SerializedName("labelPlacement")
    @Expose
    private String labelPlacement;
    @SerializedName("descriptionPlacement")
    @Expose
    private String descriptionPlacement;
    @SerializedName("subLabelPlacement")
    @Expose
    private String subLabelPlacement;
    @SerializedName("placeholder")
    @Expose
    private String placeholder;
    @SerializedName("cssClass")
    @Expose
    private String cssClass;
    @SerializedName("inputName")
    @Expose
    private String inputName;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("noDuplicates")
    @Expose
    private Boolean noDuplicates;
    @SerializedName("defaultValue")
    @Expose
    private String defaultValue;
    @SerializedName("conditionalLogic")
    @Expose
    private String conditionalLogic;
    @SerializedName("productField")
    @Expose
    private String productField;
    @SerializedName("multipleFiles")
    @Expose
    private Boolean multipleFiles;
    @SerializedName("maxFiles")
    @Expose
    private String maxFiles;
    @SerializedName("calculationFormula")
    @Expose
    private String calculationFormula;
    @SerializedName("calculationRounding")
    @Expose
    private String calculationRounding;
    @SerializedName("enableCalculation")
    @Expose
    private String enableCalculation;
    @SerializedName("disableQuantity")
    @Expose
    private Boolean disableQuantity;
    @SerializedName("displayAllCategories")
    @Expose
    private Boolean displayAllCategories;
    @SerializedName("useRichTextEditor")
    @Expose
    private Boolean useRichTextEditor;
    @SerializedName("pageNumber")
    @Expose
    private Integer pageNumber;
    @SerializedName("displayOnly")
    @Expose
    private String displayOnly;
    @SerializedName("maxLength")
    @Expose
    private String maxLength;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAdminLabel() {
        return adminLabel;
    }

    public void setAdminLabel(String adminLabel) {
        this.adminLabel = adminLabel;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getInputs() {
        return inputs;
    }

    public void setInputs(Object inputs) {
        this.inputs = inputs;
    }

    public Boolean getEnableChoiceValue() {
        return enableChoiceValue;
    }

    public void setEnableChoiceValue(Boolean enableChoiceValue) {
        this.enableChoiceValue = enableChoiceValue;
    }

    public Boolean getEnablePrice() {
        return enablePrice;
    }

    public void setEnablePrice(Boolean enablePrice) {
        this.enablePrice = enablePrice;
    }

    public Boolean getGsurveyLikertEnableMultipleRows() {
        return gsurveyLikertEnableMultipleRows;
    }

    public void setGsurveyLikertEnableMultipleRows(Boolean gsurveyLikertEnableMultipleRows) {
        this.gsurveyLikertEnableMultipleRows = gsurveyLikertEnableMultipleRows;
    }

    public Boolean getGsurveyLikertEnableScoring() {
        return gsurveyLikertEnableScoring;
    }

    public void setGsurveyLikertEnableScoring(Boolean gsurveyLikertEnableScoring) {
        this.gsurveyLikertEnableScoring = gsurveyLikertEnableScoring;
    }

    public List<Choice> getChoices() {
        return choices;
    }


    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public List<GsurveyLikertRow> getGsurveyLikertRows() {
        return gsurveyLikertRows;
    }

    public void setGsurveyLikertRows(List<GsurveyLikertRow> gsurveyLikertRows) {
        this.gsurveyLikertRows = gsurveyLikertRows;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAllowsPrepopulate() {
        return allowsPrepopulate;
    }

    public void setAllowsPrepopulate(Boolean allowsPrepopulate) {
        this.allowsPrepopulate = allowsPrepopulate;
    }

    public Boolean getInputMask() {
        return inputMask;
    }

    public void setInputMask(Boolean inputMask) {
        this.inputMask = inputMask;
    }

    public String getInputMaskValue() {
        return inputMaskValue;
    }

    public void setInputMaskValue(String inputMaskValue) {
        this.inputMaskValue = inputMaskValue;
    }

    public String getLabelPlacement() {
        return labelPlacement;
    }

    public void setLabelPlacement(String labelPlacement) {
        this.labelPlacement = labelPlacement;
    }

    public String getDescriptionPlacement() {
        return descriptionPlacement;
    }

    public void setDescriptionPlacement(String descriptionPlacement) {
        this.descriptionPlacement = descriptionPlacement;
    }

    public String getSubLabelPlacement() {
        return subLabelPlacement;
    }

    public void setSubLabelPlacement(String subLabelPlacement) {
        this.subLabelPlacement = subLabelPlacement;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Boolean getNoDuplicates() {
        return noDuplicates;
    }

    public void setNoDuplicates(Boolean noDuplicates) {
        this.noDuplicates = noDuplicates;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getConditionalLogic() {
        return conditionalLogic;
    }

    public void setConditionalLogic(String conditionalLogic) {
        this.conditionalLogic = conditionalLogic;
    }

    public String getProductField() {
        return productField;
    }

    public void setProductField(String productField) {
        this.productField = productField;
    }

    public Boolean getMultipleFiles() {
        return multipleFiles;
    }

    public void setMultipleFiles(Boolean multipleFiles) {
        this.multipleFiles = multipleFiles;
    }

    public String getMaxFiles() {
        return maxFiles;
    }

    public void setMaxFiles(String maxFiles) {
        this.maxFiles = maxFiles;
    }

    public String getCalculationFormula() {
        return calculationFormula;
    }

    public void setCalculationFormula(String calculationFormula) {
        this.calculationFormula = calculationFormula;
    }

    public String getCalculationRounding() {
        return calculationRounding;
    }

    public void setCalculationRounding(String calculationRounding) {
        this.calculationRounding = calculationRounding;
    }

    public String getEnableCalculation() {
        return enableCalculation;
    }

    public void setEnableCalculation(String enableCalculation) {
        this.enableCalculation = enableCalculation;
    }

    public Boolean getDisableQuantity() {
        return disableQuantity;
    }

    public void setDisableQuantity(Boolean disableQuantity) {
        this.disableQuantity = disableQuantity;
    }

    public Boolean getDisplayAllCategories() {
        return displayAllCategories;
    }

    public void setDisplayAllCategories(Boolean displayAllCategories) {
        this.displayAllCategories = displayAllCategories;
    }

    public Boolean getUseRichTextEditor() {
        return useRichTextEditor;
    }

    public void setUseRichTextEditor(Boolean useRichTextEditor) {
        this.useRichTextEditor = useRichTextEditor;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getDisplayOnly() {
        return displayOnly;
    }

    public void setDisplayOnly(String displayOnly) {
        this.displayOnly = displayOnly;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

}


public class GsurveyLikertRow {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("value")
    @Expose
    private String value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

    public class Choice {

        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("isSelected")
        @Expose
        private Boolean isSelected;
        @SerializedName("score")
        @Expose
        private String score;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Boolean getIsSelected() {
            return isSelected;
        }

        public void setIsSelected(Boolean isSelected) {
            this.isSelected = isSelected;
        }

        public String getPrice() {
            return score;
        }

        public void setPrice(String score) {
            this.score = score;
        }

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("text", text).append("value", value).append("isSelected", isSelected).append("price", price).toString();
    }*/

    }



public class Response {

    @SerializedName("button")
    @Expose
    private Button button;
    @SerializedName("fields")
    @Expose
    public List<Field> fields = null;



    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("labelPlacement")
    @Expose
    private String labelPlacement;
    @SerializedName("descriptionPlacement")
    @Expose
    private String descriptionPlacement;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("useCurrentUserAsAuthor")
    @Expose
    private Boolean useCurrentUserAsAuthor;
    @SerializedName("postContentTemplateEnabled")
    @Expose
    private Boolean postContentTemplateEnabled;
    @SerializedName("postTitleTemplateEnabled")
    @Expose
    private Boolean postTitleTemplateEnabled;
    @SerializedName("postTitleTemplate")
    @Expose
    private String postTitleTemplate;
    @SerializedName("postContentTemplate")
    @Expose
    private String postContentTemplate;
    @SerializedName("lastPageButton")
    @Expose
    private Object lastPageButton;
    @SerializedName("pagination")
    @Expose
    private Object pagination;
    @SerializedName("firstPageCssClass")
    @Expose
    private Object firstPageCssClass;
    @SerializedName("is_active")
    @Expose
    private String isActive;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("is_trash")
    @Expose
    private String isTrash;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabelPlacement() {
        return labelPlacement;
    }

    public void setLabelPlacement(String labelPlacement) {
        this.labelPlacement = labelPlacement;
    }

    public String getDescriptionPlacement() {
        return descriptionPlacement;
    }

    public void setDescriptionPlacement(String descriptionPlacement) {
        this.descriptionPlacement = descriptionPlacement;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getUseCurrentUserAsAuthor() {
        return useCurrentUserAsAuthor;
    }

    public void setUseCurrentUserAsAuthor(Boolean useCurrentUserAsAuthor) {
        this.useCurrentUserAsAuthor = useCurrentUserAsAuthor;
    }

    public Boolean getPostContentTemplateEnabled() {
        return postContentTemplateEnabled;
    }

    public void setPostContentTemplateEnabled(Boolean postContentTemplateEnabled) {
        this.postContentTemplateEnabled = postContentTemplateEnabled;
    }

    public Boolean getPostTitleTemplateEnabled() {
        return postTitleTemplateEnabled;
    }

    public void setPostTitleTemplateEnabled(Boolean postTitleTemplateEnabled) {
        this.postTitleTemplateEnabled = postTitleTemplateEnabled;
    }

    public String getPostTitleTemplate() {
        return postTitleTemplate;
    }

    public void setPostTitleTemplate(String postTitleTemplate) {
        this.postTitleTemplate = postTitleTemplate;
    }

    public String getPostContentTemplate() {
        return postContentTemplate;
    }

    public void setPostContentTemplate(String postContentTemplate) {
        this.postContentTemplate = postContentTemplate;
    }

    public Object getLastPageButton() {
        return lastPageButton;
    }

    public void setLastPageButton(Object lastPageButton) {
        this.lastPageButton = lastPageButton;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    public Object getFirstPageCssClass() {
        return firstPageCssClass;
    }

    public void setFirstPageCssClass(Object firstPageCssClass) {
        this.firstPageCssClass = firstPageCssClass;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getIsTrash() {
        return isTrash;
    }

    public void setIsTrash(String isTrash) {
        this.isTrash = isTrash;
    }

}


public class _59d48daf241d5 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("toType")
    @Expose
    private String toType;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("message")
    @Expose
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}


public class _59d48daf260f5 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("isDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("pageId")
    @Expose
    private String pageId;
    @SerializedName("queryString")
    @Expose
    private String queryString;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

}
}