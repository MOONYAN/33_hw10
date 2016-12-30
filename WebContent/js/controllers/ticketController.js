// angular.module('iMovie').controller('TicketController', ['TicketService', function(TicketService){
// 	var self = this;
//
// 	TicketService.getBookerTickets(function(ticketModels){
// 		self.ticketModels = ticketModels;
// 	});
// }]);

angular.module('iMovie').controller('TicketController', ['GridViewConfig', function (GridViewConfig) {
    var self = this;

    var ticketDataSource = {
        transport: {
            read: {
                url: contextPath + "/ws/tickets/booker/",
                type: "GET",
                dataType: "json",
                contentType: 'application/json'
            },
            destroy: {
                url: function (options) {
                    console.log(options);
                    return contextPath + "/ws/tickets/" + options.id;
                },
                type: "DELETE",
                dataType: "json",
                contentType: "application/json"
                // ,
                // complete: function () {
                //     self.message = "電影票已取消";
                // }
            },
            parameterMap: function (parameters, command) {
                if (command != "read")
                    return JSON.stringify(parameters);
            }
        },
        requestEnd: function(e) {
            if(e.type != "read")
                this.read();
        },
        schema: {
            model: {
                id: "id",
                fields: {
                    bookerId: { type: "number" },
                    movieName: { type: "string" },
                    showTime: { type: "date" },
                    seat: { type: "string" }
                }
            }
        },
        pageSize: 5
    };

    self.gridOptions = {
        dataSource: ticketDataSource,
        pageable: GridViewConfig.pageableOption,
        columns: GridViewConfig.ticketColumns,
        filterable: GridViewConfig.filterableOption,
        editable: "popup",
        sortable: true,
        reorderable: true,
        resizable: true
    };

    // CustomerService.getBookerTickets(function (ticketModels) {
    //     self.gridOptions = {
    //         dataSource: {data: ticketModels, pageSize: 5},
    //         pageable: GridViewConfig.pageableOption,
    //         columns: GridViewConfig.ticketColumns,
    //         filterable: GridViewConfig.filterableOption,
    //         sortable: true,
    //         reorderable: true,
    //         resizable: true
    //     };
    // });
}]);
