const Btn = document.querySelector("#btn-add");
const Form = document.querySelector("#form-add");

window.addEventListener("load", () => { Form[0].focus(); })

Btn.addEventListener("click", validate);

function validate(e) {
	e.preventDefault();

	if (Form[0].value != "") {
		if (Form[1].value != "" && Form[1].value <= 2147483647) {
			if (Form[2].value != "" && Form[2].value >= 0 && Form[2].value <= 100) {
				if (Form[3].value != "" && Form[3].value <= 2147483647) {
					if (Form[4].value != "" && Form[4].value <= 2147483647) {
						if (Form[5].value != "" && Form[5].value <= 2147483647) {
							if (Form[6].value != "") {
								add();
							} else {
								Form[6].focus();
								invalidDataAlert();
							}
						} else {
							Form[5].focus();
							invalidDataAlert();
						}
					} else {
						Form[4].focus();
						invalidDataAlert();
					}
				} else {
					Form[3].focus();
					invalidDataAlert();
				}
			} else {
			    Form[2].value = "";
				Form[2].focus();
				invalidDataAlert();
			}
		} else {
			Form[1].focus();
			invalidDataAlert();
		}
	} else {
		Form[0].focus();
		invalidDataAlert();
	}
}

function add() {
	const HttpRequest = new XMLHttpRequest();
	HttpRequest.open("POST", "http://localhost:8080/statistics", true);
	HttpRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

	let dataForm = [
		Form[0].value,
		Form[1].value,
		Form[2].value,
		Form[3].value,
		Form[4].value,
		Form[5].value,
		Form[6].value,
	];
	let statistics = {
		"country": dataForm[0],
		"population": dataForm[1],
		"waterAccessPercentage": dataForm[2],
		"populationAffectedByDrought": dataForm[3],
		"numberOfHospitals": dataForm[4],
		"numberOfHospitalsSanitationProblems": dataForm[5],
		"numberOfWaterTreatmentPlantsPerHundredThousandInhabitants": dataForm[6]
	};
	alertWell();

	HttpRequest.send(JSON.stringify(statistics));
	resetForm();
}

function resetForm() {
	Form[0].value = "";
	Form[1].value = "";
	Form[2].value = "";
	Form[3].value = "";
	Form[4].value = "";
	Form[5].value = "";
	Form[6].value = "";
}

function invalidDataAlert() {
	Swal.fire({
		icon: "error",
		title: "Oops...",
		text: "Enter valid information",
		showConfirmButton: false,
		timer: 1500
	});
}

function alertWell() {
	Swal.fire({
		title: "Added",
		icon: "success",
		showConfirmButton: false,
		timer: 1500
	});
}