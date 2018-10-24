var VividSeats = (function() {
    var _events = [];

    return {
        eventService: {
            all: function(onSuccess, onError) {
                // TODO implement network call to load all events
                this.get("http://localhost:8080/events", onSuccess);
            },
            add: function(event, onSuccess, onError) {
                // TODO implement network call to add an event
                this.post("http://localhost:8080/events", event, onSuccess);
            }
        },

        this.get = function(theUrl, callback) {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function() {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
                    callback(xmlHttp.responseText);
            }
            xmlHttp.open("GET", theUrl, true); // true for asynchronous
            xmlHttp.send(null);
        },

        this.post = function(theUrl, data, callback) {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function() {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
                    callback(xmlHttp.responseText);
            }
            xmlHttp.open("POST", theUrl, true); // true for asynchronous
            xmlHttp.send(data);
        }
    }
})();

console.log(VividSeats);

