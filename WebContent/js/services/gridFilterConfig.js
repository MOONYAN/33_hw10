angular.module('iMovie').service('GridFilterConfig', function (){
    var self = this;

    self.dropDownOperation = function(e) {
        if(e.field === "showTime") {
            e.container.data("kendoPopup").bind("open", function() {
                var beginOperator = e.container.find("[data-role=dropdownlist]:eq(0)").data("kendoDropDownList");
                beginOperator.value("gte");
                beginOperator.trigger("change");

                var endOperator = e.container.find("[data-role=dropdownlist]:eq(2)").data("kendoDropDownList");
                endOperator.value("lte");
                endOperator.trigger("change");
                e.container.find(".k-dropdown").hide();
            });
        }else if (e.field === "role") {
            var operator = e.container.find("[data-role=dropdownlist]:eq(0)").data("kendoDropDownList");
            operator.value("eq");
            operator.trigger("change");
            operator.wrapper.hide();
        }
    };

    self.roleFilter = function(element) {
        element.kendoDropDownList({
            dataTextField: "roleText",
            dataValueField: "role",
            dataSource: {
                data: [
                    { roleText: "admin", role: "admin" },
                    { roleText: "staff", role: "staff" },
                    { roleText: "customer", role: "customer" }
                ]
            },
            optionLabel: "-- 權限選擇 --"
        });
    };
});