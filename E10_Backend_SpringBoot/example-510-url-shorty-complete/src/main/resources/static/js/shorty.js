// add click handler to links table element once the html content is fully loaded
document.addEventListener('DOMContentLoaded', event => {

    let linksTable = document.getElementById("links");

    // only add eventListener to links table element to safe memory
    if (linksTable) {
        linksTable.addEventListener("click", handleClick);
    }
});

function handleClick(event) {

    if (event.target.tagName !== "BUTTON") {
        // ignore clicks on other elements
        return;
    }

    // inspect action data attribute on the button we clicked on
    let targetDataset = event.target.dataset;

    let action = targetDataset.action;
    if (action === "delete") {
        // inspect shortId data attribute on tr>td>button element
        let shortId = targetDataset.shortid;
        deleteLink(shortId);
    }

    // disable default button logic
    return false;
}

function deleteLink(shortId) {
    let path = "/api/urls/" + shortId;
    fetch(path, {
        method: 'delete'
    }).then(function (response) {
        // deletion call returned

        // reload current page
        window.location.reload();
    });
}