angular.module('iMovie').controller('MovieController', ['GridViewConfig', function (GridViewConfig) {
    var self = this;

    var movieDataSource = {
        transport: {
            read: {
                url: contextPath + "/ws/movies/store/",
                type: "GET",
                dataType: "json",
                contentType: 'application/json'
            },

            create: {
                url: contextPath + "/ws/movies",
                type: "POST",
                dataType: "json",
                contentType: 'application/json',
                complete: function () {
                    self.message = "電影已新增";
                }
            },

            destroy: {
                url: function (options) {
                    console.log(options);
                    return contextPath + "/ws/movies/" + options.id;
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
                    name: {validation: {required: true}, type: "string"},
                    image: {validation: {required: true}},
                    video: {validation: {required: true}},
                    storeId: {editable: false}
                }
            }
        },
        pageSize: 5
    };

    self.gridOptions = {
        dataSource: movieDataSource,
        pageable: GridViewConfig.pageableOption,
        columns: GridViewConfig.movieColumns,
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
