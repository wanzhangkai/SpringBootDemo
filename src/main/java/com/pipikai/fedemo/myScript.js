function myFunction() {
    document.getElementById("demo").innerHTML="我的第一个 JavaScript 函数";
}

function fun2() {
    alert("我的js文件");
}

function fun3() {
    a = 51;
    b = 6;
    c = a + b;
    console.log(c);
}

function fun4() {
    var cars = [];
    cars[0] = "wan";
    cars[1] = "zhang";
    cars[2] = "kai";
    for (i = 0;i < cars.length;i++){
        document.write(cars[i]+ "<br>");
    }
}

function fun5() {
    var  person = {
        firstName:"wan",
        lastName:"zhangkai",
        age:25,
        fullName:function () {
            return this.firstName + " "+ this.lastName;
        }
    };
    document.getElementById("demo5").innerHTML=
        person.firstName+"现在"+person.age + "岁. FullName: "+ person.fullName();
}
