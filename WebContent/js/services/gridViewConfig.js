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
        {field: 'seat', title: 'SEAT'},
        {
            headerTemplate: "作業",
            command: {
                name: "destroy",
                text: "取消訂票",
                imageClass: "k-delete",
                className: "k-grid-delete",
                iconClass: "k-icon"
            }
        }
    ];

    self.movieColumns = [
        {
            field: 'id',
            title: 'ID',
            filterable: false,
            template: '{{dataItem.id}}'
        },
        {
            field: 'name',
            title: 'MOVIE NAME',
            template: '{{dataItem.name}}',
            editor: function (container) {
                var input = $('<input class="k-input k-textbox" name="name">');
                input.appendTo(container);
            },
        },
        {
            field: 'image',
            title: 'IMAGE',
            filterable: false,
            // template: '{{dataItem.image}}',
            template: '<img src="{{dataItem.image}}" width="100%"/>',
            editor: function (container) {
                var input = $('<input class="k-input k-textbox" name="image">');
                input.appendTo(container);
            },
        },
        {
            field: 'video',
            title: 'VIDEO',
            filterable: false,
            template: '{{dataItem.video}}',
            editor: function (container) {
                var input = $('<input class="k-input k-textbox" name="video">');
                input.appendTo(container);
            },
        },
        {
            field: 'storeId',
            title: 'STORE ID',
            filterable: false,
            template: '{{dataItem.storeId}}',
        },
        {
            headerTemplate: "作業",
            command: {
                name: "destroy",
                text: "刪除電影",
                imageClass: "k-delete",
                className: "k-grid-delete",
                iconClass: "k-icon"
            }
        }
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
