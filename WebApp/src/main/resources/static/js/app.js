async function carSelect()
{
    let carSelect = document.getElementById("carSelect");
    let issueSelectionDiv = document.getElementById("issueSelection");
    let partListDiv = document.getElementById("partList");
    issueSelectionDiv.innerHTML = '';
    partListDiv.innerHTML = '';

    if(carSelect.value != -1)
    {
        let selectLabel = document.createElement("label");
        selectLabel.setAttribute("for","issueSelect");
        selectLabel.innerHTML = "Select issue: ";
        issueSelectionDiv.appendChild(selectLabel);
        let issueList;
        const res = await fetch('http://localhost:8080/issues/cars/'+ carSelect.value);
        issueList = await res.json();
        let issueSelect = document.createElement("select");
        issueSelect.setAttribute("id","issueSelect");
        issueSelect.setAttribute("name","issueSelect");
        issueSelect.setAttribute("onchange","issueSelect();");
        issueSelect.setAttribute("onfocus","this.selectedIndex = -1;");
        issueSelectionDiv.appendChild(issueSelect);
        let firstOption = document.createElement("option");
        firstOption.setAttribute("value",-1);
        firstOption.text = "Please select your issue";
        issueSelect.appendChild(firstOption);
        for(let issue of issueList)
        {
            let option = document.createElement("option");
            option.setAttribute("value",issue["id"]);
            option.text = issue["description"];
            issueSelect.appendChild(option);
        }
        
    }
}

async function issueSelect()
{
    let partListDiv = document.getElementById("partList");
    partListDiv.innerHTML = '';

    
    if(issueSelect.value != -1)
    {
        let issueSelect = document.getElementById("issueSelect");
    
        let issue;
        const issueRes = await fetch('http://localhost:8080/issues/'+ issueSelect.value);
        issue = await issueRes.json();
        const descriptionP = document.createElement("p");
        const desNode = document.createTextNode("Description:  " +issue["description"]);
        descriptionP.appendChild(desNode);
        const solutionP = document.createElement("p");
        const solNode = document.createTextNode("Solution:  " + issue["solution"]);
        solutionP.appendChild(solNode);
        let issueDiv = document.createElement("div");
        issueDiv.setAttribute("id","desSol");
        issueDiv.appendChild(descriptionP);
        issueDiv.appendChild(solutionP);
        partListDiv.appendChild(issueDiv);


        let partList;
        const res = await fetch('http://localhost:8080/parts/cars/' + document.getElementById("carSelect").value + 
        '/issues/'+ issueSelect.value);
        partList = await res.json();

        let table = document.createElement("table");
        partListDiv.appendChild(table);

        let firstTr = document.createElement("tr");
        table.appendChild(firstTr);
        for(let i of ["Image","Name","Domestic Market","Description","Price"])
        {
            let th = document.createElement("th");
            th.innerHTML = i;
            firstTr.appendChild(th);
        }

        for(let part of partList)
        {
            let tr = document.createElement("tr");
            let tdImg = document.createElement("td");
            let image = document.createElement("img");
            if(part["image"] != null)
            {
                image.setAttribute("src","data:image/jpeg;base64,"+ part["image"]["data"]);
            }
            else
            {
                image.setAttribute("src","https://static.vecteezy.com/system/resources/previews/005/337/799/non_2x/icon-image-not-found-free-vector.jpg");
            }
            image.setAttribute("height","100");
            image.setAttribute("width","100");
            tdImg.appendChild(image);
            tr.appendChild(tdImg);

            let nameTd = document.createElement("td");
            nameTd.innerHTML = part["name"];
            tr.appendChild(nameTd);

            let marketTd = document.createElement("td");
            marketTd.innerHTML = part["domesticMarket"];
            tr.appendChild(marketTd);

            let desTd = document.createElement("td");
            desTd.innerHTML = part["partDescription"];
            tr.appendChild(desTd);

            let priceTd = document.createElement("td");
            priceTd.innerHTML = part["price"] + "$";
            tr.appendChild(priceTd);

            table.appendChild(tr);
        }
    }

}