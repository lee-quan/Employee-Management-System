INSERT INTO `jeewaeducation`.`users` (`user_id`, `enabled`, `password`, `username`, `avg`) VALUES (1, 1, '$2a$10$yFgtGkrBnp9q/yopl4L6NerEXacCQ3H6n9ZYgHpoFA9VsmJUQWdp2', 'admin', 0);
INSERT INTO `Jeewaeducation`.`roles` (`role_id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `Jeewaeducation`.`roles` (`role_id`, `name`) VALUES ('2', 'EMPLOYEE');
INSERT INTO `Jeewaeducation`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');


