var app = angular.module('iMovie').controller('BookingController', ['CustomerService', function (CustomerService) {
    var self = this;
    self.selectedMovie = {};
    self.message = "";
    self.bookingModel = {
        showTime: new Date(),
        seat: '1F'
    };

    self.seats = ['1F', '2F', '3F', '4F', '5F'];

    CustomerService.getMovies(function (movieModels) {
        self.movies = movieModels;
        if(movieModels.length >0){
            self.selectedMovie = movieModels[0];
        }
    });

    self.bookTicket = function () {
        self.message = "";
        self.bookingModel.movieId = self.selectedMovie.id;
        console.log(self.bookingModel);
        CustomerService.bookTicket(self.bookingModel, function (bookingModel) {
            self.message = "book successfully with bookingId = " + bookingModel.id;
        });
    };
}]);
