$("#header").css("display", "block");
$("#selectLocationContext").css("display", "none");
$("#customerContext").css("display", "none");
$("#registerCustomerContext").css("display", "none");
$("#selectVehicleContext").css("display", "none");
$("#bookingCarContext").css("display", "none");
$(".AdminForm").css("display", "none");
$(".DriverContext").css("display", "none");
$("#registerCarContext").css("display", "none");
$("#registerDriverContext").css("display", "none");
$("#registerCustomer").css("display", "none");


$("#LinkVehicle").click(function () {
    $("#registerCustomerContext").css("display", "block");
    $("#header").css("display", "none");
    $("#selectLocationContext").css("display", "none");
    $("#selectVehicleContext").css("display", "none");
    $("#bookingCarContext").css("display", "none");
    $(".AdminForm").css("display", "none");
    $("#registerCarContext").css("display", "none");
    $("#registerCustomer").css("display", "none");
    $("#registerDriverContext").css("display", "none");


});

$(".locationbtn").click(function () {
    $("#selectVehicleContext").css("display", "block");
    $("#selectLocationContext").css("display", "block");
    $("#bookingCarContext").css("display", "none");
    $(".AdminForm").css("display", "none");
    $("#registerCarContext").css("display", "none");
    $("#registerDriverContext").css("display", "none");
    $("#registerCustomer").css("display", "none");


});
$(".btncarSelect").click(function () {
    $("#bookingCarContext").css("display", "block");
    $("#selectLocationContext").css("display", "block");
    $("#selectVehicleContext").css("display", "none");
    $(".AdminForm").css("display", "none");
    $("#registerCarContext").css("display", "none");
    $("#registerDriverContext").css("display", "none");
    $("#registerCustomer").css("display", "none");

});

$("#AdminButton").click(function () {
    $(".AdminForm").css("display", "block");
    $("#header").css("display", "none");
    $("#selectLocationContext").css("display", "none");
    $("#registerCustomer").css("display", "none");
    $("#customerContext").css("display", "none");
    $("#registerCustomerContext").css("display", "none");
    $("#selectVehicleContext").css("display", "none");
    $("#bookingCarContext").css("display", "none");
    $("#ADriverContext").css("display", "none");
    $("#registerCarContext").css("display", "none");
    $("#registerDriverContext").css("display", "none");

});

$(".Driverbtn").click(function () {
    $("#registerDriverContext").css("display", "block");
    $(".AdminForm").css("display", "block");
    $("#registerCarContext").css("display", "none");
    $("#header").css("display", "none");
    $("#selectLocationContext").css("display", "none");
    $("#customerContext").css("display", "none");
    $("#registerCustomer").css("display", "none");
    $("#registerCustomerContext").css("display", "none");
    $("#selectVehicleContext").css("display", "none");
    $("#bookingCarContext").css("display", "none");
    $("#ADriverContext").css("display", "none");
});

$(".Carbtn").click(function () {
    $("#registerCarContext").css("display", "block");
    $("#registerCustomer").css("display", "none");
    $(".AdminForm").css("display", "block");
    $("#bookingCarContext").css("display", "none");
    $("#registerDriverContext").css("display", "none");
    $("#header").css("display", "none");
    $("#selectLocationContext").css("display", "none");
    $("#customerContext").css("display", "none");
    $("#registerCustomerContext").css("display", "none");
    $("#selectVehicleContext").css("display", "none");
    $("#ADriverContext").css("display", "none");
});
$(".Customerbtn").click(function () {
    $("#registerCustomer").css("display", "block");
    $(".AdminForm").css("display", "block");
    $("#registerCarContext").css("display", "none");
    $("#bookingCarContext").css("display", "none");
    $("#registerDriverContext").css("display", "none");
    $("#header").css("display", "none");
    $("#selectLocationContext").css("display", "none");
    $("#customerContext").css("display", "none");
    $("#selectVehicleContext").css("display", "none");
    $("#ADriverContext").css("display", "none");
});
const basecustomer = "http://localhost:8080/SpringCourceWork_war_exploded/customer";
const basecar = "http://localhost:8080/SpringCourceWork_war_exploded/car";
const basedriver = "http://localhost:8080/SpringCourceWork_war_exploded/driver";
const basereservation = "http://localhost:8080/SpringCourceWork_war_exploded/reservation";

loadAllCustomers();
loadAllCars();
loadAllDriver();

$("#btnSaveCustomer").click(function () {
    saveCustomer();
    var val = $("#cusID").val();
    var val1 = $("#cId").text(val);
    console.log(val1);

});
$("#SaveCustomer").click(function () {
    ACustomer();
    loadAllCustomers();

});
$("#btnSaveCar").click(function () {
    saveCar();
    loadAllCars();
});
$("#btnSaveOrder").click(function () {
    saveOrder();
});
$("#btnSaveDriver").click(function () {
    saveDriver();
    loadAllDriver();
});
$("#btnDeleteCustomer").click(function () {
    deleteCustomer();
    loadAllCustomers();
});
$("#btnDeleteCar").click(function () {
    deleteCar();
});
$("#btnDeleteDriver").click(function () {
    deleteDriver();
});
$("#btnUpdateCustomer").click(function () {
    updateCustomers();
});
$("#from").click(function () {
    $("#title").text("Where can we pick you up?");
});
$("#to").click(function () {
    $("#title").text("Where to?");
});

function saveCustomer() {
    var data = $("#customerForme").serialize(); // return query string of form with name:type-value

    $.ajax({
        url: basecustomer,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                var valert = confirm("Successfully Customer Registered");
                if (valert == true) {
                    $("#selectLocationContext").css("display", "block");
                    $("#registerCustomerContext").css("display", "none");
                    $("#header").css("display", "none");
                    $("#customerContext").css("display", "none");
                    $("#selectVehicleContext").css("display", "none");
                    $("#bookingCarContext").css("display", "none");
                    $(".AdminForm").css("display", "none");
                    $("#registerCarContext").css("display", "none");
                    $("#registerDriverContext").css("display", "none");
                    $("#registerCustomer").css("display", "none");
                } else {
                    confirm(" Customer Already Registered");
                }
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function ACustomer() {
    var data = $("#AdmincustomerForme").serialize(); // return query string of form with name:type-value
    $.ajax({
        url: basecustomer,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                loadAllCustomers();
                confirm("Successfully Customer Registered");
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function saveCar() {
    var data = $("#carForme").serialize();
    $.ajax({
        url: basecar,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                confirm("Successfully Car Registered");
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function saveDriver() {
    var data = $("#driverForm").serialize();
    $.ajax({
        url: basedriver,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                confirm("Successfully Driver Registered");
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function saveOrder() {
    var data = $("#orderForm").serialize(); // return query string of form with name:type-value
    $.ajax({
        url: baseOrder,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                alert("Successfully Customer Registered");
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

$("#custID").on("keypress", function (e) {
    if (e.key == "Enter") {
        searchCustomer();
    }
});

$("#txtcarId").on("keypress", function (e) {
    if (e.key == "Enter") {
        searchCar();
    }
});

function searchCustomer() {
    var customerID = $("#crustID").val();

    $.ajax({
        url: basecustomer + "/" + customerID,
        method: "GET",
        success: function (res) {
            if (res.code = 200) {
                var customer = res.data;
                $("#crustID").val(customer.cid);
                $("#crustName").val(customer.cname);
                $("#crustAddress").val(customer.address);
                $("#crustHouseNo").val(customer.houseNo);
                $("#custLicen").val(customer.licence);
                $("#crustTel").val(customer.number);
                $("#crustCity").val(customer.city);
            } else {
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function bindClickEvent() {
    $("#tablecustomer>tr").click(function () {
        let cid = $(this).children().eq(0).text();
        let cname = $(this).children().eq(1).text();
        let caddress = $(this).children().eq(2).text();
        let ccity = $(this).children().eq(3).text();
        let hnumber = $(this).children().eq(4).text();
        let clicence = $(this).children().eq(5).text();
        let cteliphone = $(this).children().eq(6).text();


        //Set values to the text-fields
        $("#crustID").val(cid);
        $("#crustName").val(cname);
        $("#crustAddress").val(caddress);
        $("#crustHouseNo").val(hnumber);
        $("#custLicen").val(clicence);
        $("#crustTel").val(cteliphone);
        $("#crustCity").val(ccity);
    });
}

function bindClickEventDriver() {
    $("#driverTable>tr").click(function () {
        let did = $(this).children().eq(0).text();
        let dname = $(this).children().eq(1).text();
        let daddress = $(this).children().eq(2).text();
        let dsalary = $(this).children().eq(3).text();
        let dteliphone = $(this).children().eq(4).text();
        let Drivinglicen = $(this).children().eq(5).text();
        let joindate = $(this).children().eq(6).text();


        //Set values to the text-fields
        $("#DId").val(did);
        $("#dname").val(dname);
        $("#daddress").val(daddress);
        $("#dsalary").val(dsalary);
        $("#dteliphone").val(dteliphone);
        $("#Drivinglicen").val(Drivinglicen);
        $("#joindate").val(joindate);
    });
}

function bindClickEventCar() {
    $("#carTable>tr").click(function () {
        let cId = $(this).children().eq(0).text();
        let palte = $(this).children().eq(1).text();
        let dailyPrice = $(this).children().eq(2).text();
        let miladge = $(this).children().eq(3).text();
        let carQty = $(this).children().eq(4).text();
        let model = $(this).children().eq(5).text();


        //Set values to the text-fields
        $("#txtcarId").val(cId);
        $("#txtplateNo").val(palte);
        $("#txtdailyprice").val(dailyPrice);
        $("#txtmiladge").val(miladge);
        $("#txtqty").val(carQty);
        $("#txtcarModel").val(model);
    });
}

function searchCar() {
    var carId = $("#txtcarId").val();

    $.ajax({
        url: basecar + "/" + carId,
        method: "GET",
        success: function (res) {
            if (res.code = 200) {
                var car = res.data;
                console.log(car);
                $("#txtcarId").val(car.carId);
                $("#txtplateNo").val(car.plateNo);
                $("#txtdailyprice").val(car.DailyPrice);
                $("#txtmiladge").val(car.miladge);
                $("#txtqty").val(car.carQty);
                $("#txtcarModel").val(car.Model);
            } else {
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function deleteCustomer() {
    let customerID = $("#crustID").val();

    $.ajax({
        url: basecustomer + "?id=" + customerID,// viya query string
        method: "DELETE",
        //data:data,// application/x-www-form-urlencoded
        success: function (res) {
            if (res.code == 200) {
                alert("Customer Successfully Deleted");
                loadAllCustomers();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function deleteDriver() {
    let driverId = $("#DId").val();

    $.ajax({
        url: basedriver + "?id=" + driverId,// viya query string
        method: "DELETE",
        //data:data,// application/x-www-form-urlencoded
        success: function (res) {
            if (res.code == 200) {
                alert("Driver Successfully Deleted");
                loadAllDriver();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function deleteCar() {
    let carId = $("#txtcarId").val();

    $.ajax({
        url: basecar + "?id=" + carId,// viya query string
        method: "DELETE",
        //data:data,// application/x-www-form-urlencoded
        success: function (res) {
            if (res.code == 200) {
                alert("Car Successfully Deleted");
                loadAllCars();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function updateCustomers() {
    var cus = {
        id: $("#crustID").val(),
        name: $("#crustName").val(),
        address: $("#crustAddress").val(),
        city: $("#crustCity").val(),
        houseno: $("#crustHouseNo").val(),
        license: $("#custLicen").val(),
        teliphone: $("#crustTel").val(),
    }
    console.log(cus);
    $.ajax({
        url: basecustomer,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(cus),
        success: function (res) {

            if (res.code == 200) {
                alert("Successfully Updated");
                loadAllCustomers();
            }

        },
        error: function (ob) {
            alert(ob.responseJSON.message);

        }
    });
}

function loadAllCustomers() {
    $("#tablecustomer").empty();
    $.ajax({
        url: basecustomer,
        method: "GET",
        success: function (resp) {
            for (const customer of resp.data) {
                console.log(resp.data);
                let row = `<tr><td>${customer.cid}</td><td>${customer.cname}</td><td>${customer.address}</td><td>${customer.city}</td><td>${customer.houseNo}</td><td>${customer.licence}</td><td>${customer.number}</td></tr>`;
                $("#tablecustomer").append(row);
            }
            bindClickEvent();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);

        }
    });
}

function loadAllCars() {
    $("#carTable").empty();
    $.ajax({
        url: basecar,
        method: "GET",
        success: function (resp) {
            for (const car of resp.data) {
                console.log(resp.data);
                let row = `<tr><td>${car.carId}</td><td>${car.plateNo}</td><td>${car.dailyPrice}</td><td>${car.miladge}</td><td>${car.carQty}</td><td>${car.model}</td></tr>`;
                $("#carTable").append(row);
            }
            bindClickEventCar();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);

        }
    });
}

function loadAllDriver() {
    $("#driverTable").empty();
    $.ajax({
        url: basedriver,
        method: "GET",
        success: function (resp) {
            for (const driver of resp.data) {
                console.log(resp.data);
                let row = `<tr><td>${driver.did}</td><td>${driver.dname}</td><td>${driver.daddress}</td><td>${driver.dsalary}</td><td>${driver.dteliphone}</td><td>${driver.drivinglicen}</td><td>${driver.joindate}</td></tr>`;
                $("#driverTable").append(row);
            }
            bindClickEventDriver();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);

        }
    });
}

$("#btnBooking").click(function () {
    BookingForm();
});

function BookingForm() {
    let data = $("#BookingForm").serialize();
    $.ajax({
        url: basereservation,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                alert("Your Order Confirm");
            }
        }

    });
}
