angular.module('iMovie').service('GridViewConfig', function (GridFilterConfig) {
    var self = this;

    self.pageableOption = {
        messages: {
            display: "{0} - {1} 共  {2} 筆",
            empty: "無資料顯示"
        }
    };

    self.ticketColumns = [
        {field: 'id', title: 'ID', filterable: false},
        {field: 'bookerId', title: 'BOOKER ID'},
        {field: 'movieName', title: 'MOVIE NAME'},
        {field: 'showTime', title: 'SHOW TIME', format: "{0:yyyy-MM-dd}"},
        {field: 'seat', title: 'SEAT'}
    ];

    self.filterableOption = {
        extra: false,
        messages: {
            info: "查詢條件",
            filter: "查詢",
            clear: "清除"
        },
        operators: {
            string: {
                contains: "文字包含",
                doesnotcontain: "文字不包含",
                eq: "文字等於",
                neq: "文字不等於",
                startswith: "文字開頭"
            },
            number: {
                eq: "等於",
                gt: "大於",
                gte: "大於或等於",
                lt: "小於",
                lte: "小於或等於"
            },
            date: {
                gte: "日期晚於",
                lte: "日期早於"
            }
        }
    };
});
