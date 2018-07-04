package com.pumpun.proyectformapiantoniogonzalez.POJO;

/**
 * Created by pumpun5 on 4/10/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Formulario {

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

   /* @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("response", response).toString();
    }*/


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

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("text", text).append("imageUrl", imageUrl).toString();
    }*/

    }


    public class Button_ {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("text")
        @Expose
        private String text;

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

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("text", text).toString();
    }*/

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
        @SerializedName("price")
        @Expose
        private String price;

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
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("text", text).append("value", value).append("isSelected", isSelected).append("price", price).toString();
    }*/

    }


 /*class Confirmations {

    @SerializedName("59ccaccede10e")
    @Expose
    private com.pumpun.wordpressapi.POJO._59ccaccede10e _59ccaccede10e;

    public com.pumpun.wordpressapi.POJO._59ccaccede10e get59ccaccede10e() {
        return _59ccaccede10e;
    }

    public void set59ccaccede10e(com.pumpun.wordpressapi.POJO._59ccaccede10e _59ccaccede10e) {
        this._59ccaccede10e = _59ccaccede10e;
    }

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("_59ccaccede10e", _59ccaccede10e).toString();
    }*/

//}


    public static class Field {

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
        @SerializedName("choices")
        @Expose
        private List<Choice> choices = null;
        @SerializedName("inputs")
        @Expose
        private List<Input> inputs = null;
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
        @SerializedName("inputType")
        @Expose
        private String inputType;
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
        @SerializedName("enablePrice")
        @Expose
        private String enablePrice;
        @SerializedName("pageNumber")
        @Expose
        private Integer pageNumber;
        @SerializedName("displayOnly")
        @Expose
        private String displayOnly;
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

        public List<Choice> getChoices() {
            return choices;
        }

        public void setChoices(List<Choice> choices) {
            this.choices = choices;
        }

        public List<Input> getInputs() {
            return inputs;
        }

        public void setInputs(List<Input> inputs) {
            this.inputs = inputs;
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

        public String getInputType() {
            return inputType;
        }

        public void setInputType(String inputType) {
            this.inputType = inputType;
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

        public String getEnablePrice() {
            return enablePrice;
        }

        public void setEnablePrice(String enablePrice) {
            this.enablePrice = enablePrice;
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

   /* @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("id", id).append("label", label).append("adminLabel", adminLabel).append("isRequired", isRequired).append("size", size).append("errorMessage", errorMessage).append("choices", choices).append("inputs", inputs).append("formId", formId).append("description", description).append("allowsPrepopulate", allowsPrepopulate).append("inputMask", inputMask).append("inputMaskValue", inputMaskValue).append("inputType", inputType).append("labelPlacement", labelPlacement).append("descriptionPlacement", descriptionPlacement).append("subLabelPlacement", subLabelPlacement).append("placeholder", placeholder).append("cssClass", cssClass).append("inputName", inputName).append("visibility", visibility).append("noDuplicates", noDuplicates).append("defaultValue", defaultValue).append("conditionalLogic", conditionalLogic).append("productField", productField).append("enablePrice", enablePrice).append("pageNumber", pageNumber).append("displayOnly", displayOnly).append("multipleFiles", multipleFiles).append("maxFiles", maxFiles).append("calculationFormula", calculationFormula).append("calculationRounding", calculationRounding).append("enableCalculation", enableCalculation).append("disableQuantity", disableQuantity).append("displayAllCategories", displayAllCategories).append("useRichTextEditor", useRichTextEditor).toString();
    }*/

    }



    class Input {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("name")
        @Expose
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("label", label).append("name", name).toString();
    }*/

    }


 /*class Notifications {

    @SerializedName("59ccaccedc98e")
    @Expose
    private com.pumpun.wordpressapi.POJO._59ccaccedc98e _59ccaccedc98e;

    public com.pumpun.wordpressapi.POJO._59ccaccedc98e get59ccaccedc98e() {
        return _59ccaccedc98e;
    }

    public void set59ccaccedc98e(com.pumpun.wordpressapi.POJO._59ccaccedc98e _59ccaccedc98e) {
        this._59ccaccedc98e = _59ccaccedc98e;
    }
*/
   /* @Override
    public String toString() {
        return new ToStringBuilder(this).append("_59ccaccedc98e", _59ccaccedc98e).toString();
    }*/

//}


    public class Response {

        public Field field;

        public Field getField(){
            return field;
        }
        public void setField(Field field){
            this.field=field;
        }

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
        @SerializedName("button")
        @Expose
        private Button button;
        @SerializedName("fields")
        @Expose
        public List<Field> fields = null;
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
        @SerializedName("subLabelPlacement")
        @Expose
        private String subLabelPlacement;
        @SerializedName("cssClass")
        @Expose
        private String cssClass;
        @SerializedName("enableHoneypot")
        @Expose
        private Boolean enableHoneypot;
        @SerializedName("enableAnimation")
        @Expose
        private Boolean enableAnimation;
        @SerializedName("save")
        @Expose
        private Save save;
        @SerializedName("limitEntries")
        @Expose
        private Boolean limitEntries;
        @SerializedName("limitEntriesCount")
        @Expose
        private String limitEntriesCount;
        @SerializedName("limitEntriesPeriod")
        @Expose
        private String limitEntriesPeriod;
        @SerializedName("limitEntriesMessage")
        @Expose
        private String limitEntriesMessage;
        @SerializedName("scheduleForm")
        @Expose
        private Boolean scheduleForm;
        @SerializedName("scheduleStart")
        @Expose
        private String scheduleStart;
        @SerializedName("scheduleStartHour")
        @Expose
        private String scheduleStartHour;
        @SerializedName("scheduleStartMinute")
        @Expose
        private String scheduleStartMinute;
        @SerializedName("scheduleStartAmpm")
        @Expose
        private String scheduleStartAmpm;
        @SerializedName("scheduleEnd")
        @Expose
        private String scheduleEnd;
        @SerializedName("scheduleEndHour")
        @Expose
        private String scheduleEndHour;
        @SerializedName("scheduleEndMinute")
        @Expose
        private String scheduleEndMinute;
        @SerializedName("scheduleEndAmpm")
        @Expose
        private String scheduleEndAmpm;
        @SerializedName("schedulePendingMessage")
        @Expose
        private String schedulePendingMessage;
        @SerializedName("scheduleMessage")
        @Expose
        private String scheduleMessage;
        @SerializedName("requireLogin")
        @Expose
        private Boolean requireLogin;
        @SerializedName("requireLoginMessage")
        @Expose
        private String requireLoginMessage;
        /* @SerializedName("notifications")
         @Expose
         private Notifications notifications;
         @SerializedName("confirmations")
         @Expose
         private Confirmations confirmations;*/
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

        public String getSubLabelPlacement() {
            return subLabelPlacement;
        }

        public void setSubLabelPlacement(String subLabelPlacement) {
            this.subLabelPlacement = subLabelPlacement;
        }

        public String getCssClass() {
            return cssClass;
        }

        public void setCssClass(String cssClass) {
            this.cssClass = cssClass;
        }

        public Boolean getEnableHoneypot() {
            return enableHoneypot;
        }

        public void setEnableHoneypot(Boolean enableHoneypot) {
            this.enableHoneypot = enableHoneypot;
        }

        public Boolean getEnableAnimation() {
            return enableAnimation;
        }

        public void setEnableAnimation(Boolean enableAnimation) {
            this.enableAnimation = enableAnimation;
        }

        public Save getSave() {
            return save;
        }

        public void setSave(Save save) {
            this.save = save;
        }

        public Boolean getLimitEntries() {
            return limitEntries;
        }

        public void setLimitEntries(Boolean limitEntries) {
            this.limitEntries = limitEntries;
        }

        public String getLimitEntriesCount() {
            return limitEntriesCount;
        }

        public void setLimitEntriesCount(String limitEntriesCount) {
            this.limitEntriesCount = limitEntriesCount;
        }

        public String getLimitEntriesPeriod() {
            return limitEntriesPeriod;
        }

        public void setLimitEntriesPeriod(String limitEntriesPeriod) {
            this.limitEntriesPeriod = limitEntriesPeriod;
        }

        public String getLimitEntriesMessage() {
            return limitEntriesMessage;
        }

        public void setLimitEntriesMessage(String limitEntriesMessage) {
            this.limitEntriesMessage = limitEntriesMessage;
        }

        public Boolean getScheduleForm() {
            return scheduleForm;
        }

        public void setScheduleForm(Boolean scheduleForm) {
            this.scheduleForm = scheduleForm;
        }

        public String getScheduleStart() {
            return scheduleStart;
        }

        public void setScheduleStart(String scheduleStart) {
            this.scheduleStart = scheduleStart;
        }

        public String getScheduleStartHour() {
            return scheduleStartHour;
        }

        public void setScheduleStartHour(String scheduleStartHour) {
            this.scheduleStartHour = scheduleStartHour;
        }

        public String getScheduleStartMinute() {
            return scheduleStartMinute;
        }

        public void setScheduleStartMinute(String scheduleStartMinute) {
            this.scheduleStartMinute = scheduleStartMinute;
        }

        public String getScheduleStartAmpm() {
            return scheduleStartAmpm;
        }

        public void setScheduleStartAmpm(String scheduleStartAmpm) {
            this.scheduleStartAmpm = scheduleStartAmpm;
        }

        public String getScheduleEnd() {
            return scheduleEnd;
        }

        public void setScheduleEnd(String scheduleEnd) {
            this.scheduleEnd = scheduleEnd;
        }

        public String getScheduleEndHour() {
            return scheduleEndHour;
        }

        public void setScheduleEndHour(String scheduleEndHour) {
            this.scheduleEndHour = scheduleEndHour;
        }

        public String getScheduleEndMinute() {
            return scheduleEndMinute;
        }

        public void setScheduleEndMinute(String scheduleEndMinute) {
            this.scheduleEndMinute = scheduleEndMinute;
        }

        public String getScheduleEndAmpm() {
            return scheduleEndAmpm;
        }

        public void setScheduleEndAmpm(String scheduleEndAmpm) {
            this.scheduleEndAmpm = scheduleEndAmpm;
        }

        public String getSchedulePendingMessage() {
            return schedulePendingMessage;
        }

        public void setSchedulePendingMessage(String schedulePendingMessage) {
            this.schedulePendingMessage = schedulePendingMessage;
        }

        public String getScheduleMessage() {
            return scheduleMessage;
        }

        public void setScheduleMessage(String scheduleMessage) {
            this.scheduleMessage = scheduleMessage;
        }

        public Boolean getRequireLogin() {
            return requireLogin;
        }

        public void setRequireLogin(Boolean requireLogin) {
            this.requireLogin = requireLogin;
        }

        public String getRequireLoginMessage() {
            return requireLoginMessage;
        }

        public void setRequireLoginMessage(String requireLoginMessage) {
            this.requireLoginMessage = requireLoginMessage;
        }
        /*
            public Notifications getNotifications() {
                return notifications;
            }

            public void setNotifications(Notifications notifications) {
                this.notifications = notifications;
            }

            public Confirmations getConfirmations() {
                return confirmations;
            }

            public void setConfirmations(Confirmations confirmations) {
                this.confirmations = confirmations;
            }
        */
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

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("description", description).append("labelPlacement", labelPlacement).append("descriptionPlacement", descriptionPlacement).append("button", button).append("fields", fields).append("version", version).append("id", id).append("useCurrentUserAsAuthor", useCurrentUserAsAuthor).append("postContentTemplateEnabled", postContentTemplateEnabled).append("postTitleTemplateEnabled", postTitleTemplateEnabled).append("postTitleTemplate", postTitleTemplate).append("postContentTemplate", postContentTemplate).append("lastPageButton", lastPageButton).append("pagination", pagination).append("firstPageCssClass", firstPageCssClass).append("subLabelPlacement", subLabelPlacement).append("cssClass", cssClass).append("enableHoneypot", enableHoneypot).append("enableAnimation", enableAnimation).append("save", save).append("limitEntries", limitEntries).append("limitEntriesCount", limitEntriesCount).append("limitEntriesPeriod", limitEntriesPeriod).append("limitEntriesMessage", limitEntriesMessage).append("scheduleForm", scheduleForm).append("scheduleStart", scheduleStart).append("scheduleStartHour", scheduleStartHour).append("scheduleStartMinute", scheduleStartMinute).append("scheduleStartAmpm", scheduleStartAmpm).append("scheduleEnd", scheduleEnd).append("scheduleEndHour", scheduleEndHour).append("scheduleEndMinute", scheduleEndMinute).append("scheduleEndAmpm", scheduleEndAmpm).append("schedulePendingMessage", schedulePendingMessage).append("scheduleMessage", scheduleMessage).append("requireLogin", requireLogin).append("requireLoginMessage", requireLoginMessage).append("notifications", notifications).append("confirmations", confirmations).append("isActive", isActive).append("dateCreated", dateCreated).append("isTrash", isTrash).toString();
    }*/

    }


    class Save {

        @SerializedName("enabled")
        @Expose
        private Boolean enabled;
        @SerializedName("button")
        @Expose
        private Button_ button;

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public Button_ getButton() {
            return button;
        }

        public void setButton(Button_ button) {
            this.button = button;
        }

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("enabled", enabled).append("button", button).toString();
    }*/

    }

    class _59ccaccedc98e {

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

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("to", to).append("name", name).append("event", event).append("toType", toType).append("subject", subject).append("message", message).toString();
    }*/

    }


    class _59ccaccede10e {

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

   /* @Override
    public String toString() {
        return new "id="+id+",name="+name+", name).append("isDefault", isDefault).append("type", type).append("message", message).append("url", url).append("pageId", pageId)" +
                ".append("queryString", queryString).toString()";
    }*/

    }
}