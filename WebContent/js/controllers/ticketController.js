// angular.module('iMovie').controller('TicketController', ['TicketService', function(TicketService){
// 	var self = this;
//
// 	TicketService.getBookerTickets(function(ticketModels){
// 		self.ticketModels = ticketModels;
// 	});
// }]);

angular.module('iMovie').controller('TicketController', ['GridViewConfig','CustomerService', function (GridViewConfig,CustomerService) {
    var self = this;
    CustomerService.getBookerTickets(function(ticketModels){
        self.gridOptions = {
            dataSource: {data: ticketModels, pageSize: 5},
            pageable: GridViewConfig.pageableOption,
            columns: GridViewConfig.ticketColumns,
            filterable: GridViewConfig.filterableOption,
            sortable: true,
            reorderable: true,
            resizable: true
        };
    });
}]);
