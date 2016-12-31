angular.module('iMovie').config(['$stateProvider', function ($stateProvider) {
    $stateProvider
        .state('listBookerTickets', {
            url: '/listBookerTickets',
            templateUrl: contextPath + '/views/ticketList.jsp',
            controller: 'TicketController',
            controllerAs: 'TicketCtrl'
        })
        .state('booking', {
            url: '/booking',
            templateUrl: contextPath + '/views/booking.html',
            controller: 'BookingController',
            controllerAs: 'BookingCtrl'
        });
}]);
