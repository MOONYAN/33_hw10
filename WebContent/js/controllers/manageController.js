angular.module('iMovie').controller('ManageController', ['GridViewConfig', 'GridFilterConfig', function (GridViewConfig, GridFilterConfig) {
    var self = this;

    var manageDataSource = {
        transport: {
            read: {
                url: contextPath + "/ws/users/",
                type: "GET",
                dataType: "json",
                contentType: 'application/json',
                complete: function (options) {
                    console.log(options);
                }
            },

            create: {
                url: contextPath + "/ws/users",
                type: "POST",
                dataType: "json",
                contentType: 'application/json',
                complete: function () {
                    self.message = "職員已新增";
                }
            },

            destroy: {
                url: function (options) {
                    console.log(options);
                    return contextPath + "/ws/users/" + options.id;
                },
                type: "DELETE",
                dataType: "json",
                contentType: "application/json"
            },
            parameterMap: function (parameters, command) {
                if (command != "read")
                    return JSON.stringify(parameters);
            }
        },
        requestEnd: function (e) {
            if (e.type != "read")
                this.read();
        },
        schema: {
            model: {
                id: "id",
                fields: {
                    id: {editable: false},
                    username: {validation: {required: true}, type: "string"},
                    password: {validation: {required: true}},
                    role: {validation: {required: true}}
                }
            }
        },
        pageSize: 5
    };

    self.gridOptions = {
        dataSource: manageDataSource,
        pageable: GridViewConfig.pageableOption,
        columns: GridViewConfig.manageColumns,
        filterable: GridViewConfig.filterableOption,
        toolbar: [
            {name: "create", text: "新增", imageClass: "k-add", className: "k-grid-add", iconClass: "k-icon"}
        ],
        editable: "popup",
        sortable: true,
        reorderable: true,
        resizable: true
    };
}]);