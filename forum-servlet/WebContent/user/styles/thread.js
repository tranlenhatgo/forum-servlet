function getCurrentDateTime() {
  var currentDate = new Date();

  var hours = addLeadingZero(currentDate.getHours());
  var minutes = addLeadingZero(currentDate.getMinutes());
  var day = addLeadingZero(currentDate.getDate());
  var month = addLeadingZero(currentDate.getMonth() + 1); // Months are zero-based
  var year = currentDate.getFullYear();

  var dateTimeString =
    hours + ":" + minutes + " " + day + "/" + month + "/" + year;

  return dateTimeString;
}

// Helper function to add leading zero if the value is less than 10
function addLeadingZero(value) {
  return value < 10 ? "0" + value : value;
}

function createPost() {
  // Get the input values
  var postContent = document.getElementById("postContent").value;
  var postImageInput = document.getElementById("postImage");
  var currentDateTime = getCurrentDateTime();

  // Check if an image file is selected
  if (postImageInput.files.length > 0) {
    var postImage = postImageInput.files[0];

    // Read the image file using FileReader
    var reader = new FileReader();
    reader.onload = function (event) {
      var postImageURL = event.target.result;

      // Create the post HTML with the image
      var postHTML = `
        <div class="post">
          <div class="head-post">
            <img src="/img/per1.jpg" alt="#" />
            <p><a href="#">YName</a> post in /manga/ at ${currentDateTime}</p>
            <div>
              <ion-icon name="ellipsis-vertical-outline"></ion-icon>
            </div>
          </div>
          <div class="body-post">
            <img src="${postImageURL}" alt="#" />
            <p>${postContent}</p>
          </div>
          <div class="end-post">
            <ion-icon name="caret-up" id="upbtn" onclick="upvote(this)"></ion-icon>
            <p id="upvote">0</p>
            <ion-icon name="caret-down" id="downbtn" onclick="downvote(this)"></ion-icon>
            <p id="downvote">0</p>
            <ion-icon name="chatbox-ellipses-outline"></ion-icon>
            <p>0</p>
            <ion-icon name="arrow-redo-circle-outline"></ion-icon>
          </div>
        </div>
      `;

      // Insert the post HTML into the container
      var containerElement = document.querySelector(".col-9");
      containerElement.insertAdjacentHTML("afterbegin", postHTML);

      // Close the modal
      var createPostModal = document.getElementById("createPostModal");
      var modal = bootstrap.Modal.getInstance(createPostModal);
      modal.hide();
    };

    // Read the image file as a data URL
    reader.readAsDataURL(postImage);
  }
}
function upvote(button) {
  let upvote = button.parentNode.querySelector("#upvote");
  upvote.innerHTML = parseInt(upvote.innerHTML) + 1;
  button.parentNode.querySelector("#downbtn").onclick = null;
  button.parentNode.querySelector("#upbtn").onclick = null;
}
function downvote(button) {
  let downvote = button.parentNode.querySelector("#downvote");
  downvote.innerHTML = parseInt(downvote.innerHTML) + 1;
  button.parentNode.querySelector("#downbtn").onclick = null;
  button.parentNode.querySelector("#upbtn").onclick = null;
}
