document.addEventListener("DOMContentLoaded", function() {
  var trigger = document.querySelector('.trigger');
  var modalWrapper = document.querySelector('.modal-wrapper');
  var pageWrapper = document.querySelector('.page-wrapper');
  var closeModal = document.querySelector('.btn-close');

  trigger.addEventListener('click', function() {
      modalWrapper.classList.add('open');
      pageWrapper.classList.add('blur');
      return false;
  });

  closeModal.addEventListener('click', function() {
      modalWrapper.classList.remove('open');
      pageWrapper.classList.remove('blur');
      return false;
  });
});