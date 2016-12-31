angular.module('iMovie').config(['$stateProvider', function ($stateProvider) {
    $stateProvider
        .state('listStoreMovies', {
            url: '/listStoreMovies',
            templateUrl: contextPath + '/views/movieList.html',
            controller: 'MovieController',
            controllerAs: 'MovieCtrl'
        })
        .state('manage', {
            url: '/manage',
            templateUrl: contextPath + '/views/manage.html',
            controller: 'manageController',
            controllerAs: 'manageCtrl'
        });
}]);
