$(document).ready(()=> {

    var url = "http://dummy.restapiexample.com/api/v1/employees"

    getList(url);


})

function getList(url) {
    
    $.ajax({
        url: url,
        method: 'GET',
        success: (response) => {
            var result = JSON.parse(response);
            $.each(result, (index, value) => {
                console.log(value);
                var option = `<option value="${value.employee_name}"> </option>`
                $("#employees").append(option);
            })
        },
        error: (response) => {
            console.log(response);
        } 


    })

}