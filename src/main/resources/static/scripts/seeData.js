window.addEventListener("load", writeTable);

function writeTable() {
	const HttpRequest = new XMLHttpRequest();

	HttpRequest.onreadystatechange = function() {
		if (HttpRequest.readyState === XMLHttpRequest.DONE) {
			let status = HttpRequest.status;

			if (status === 0 || (status >= 200 && status < 400)) {
				let json = JSON.parse(HttpRequest.responseText);
				createTable(json);
			} else {
				console.log("Error");
			}
		}
	};
	HttpRequest.open("GET", "http://localhost:8080/statistics", true);
	HttpRequest.send();
}

function createTable(json) {
	const Tbody = document.querySelector("#tbody");
	let i = 0

	json.forEach((row) => {
		i++;
		let tr = document.createElement("tr");

		let arr = Object.values(row);
		arr.unshift(i);

		arr.forEach((celda) => {
				let td = document.createElement("td");
				td.textContent = celda;
				tr.appendChild(td);
			}

		);
		Tbody.appendChild(tr)

	});
}