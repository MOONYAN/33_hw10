angular.module('iMovie').run(['$state', function($state){
    $state.go('listStoreMovies');
}]);
