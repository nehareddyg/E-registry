app.service('Session', function () {
    this.create = function (sessionId, userId, userName, userRole) {
        console.log("hey");
       /* this.id = sessionId;
        this.name = userId;
        this.username = userName;
        this.role = userRole*/
    };
    this.destroy = function () {
        this.id = null;
        this.name= null;
        this.username=null;
        this.role = null;
    };
})