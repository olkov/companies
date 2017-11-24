Technologies are used: HTML, CSS, JavaScript, JQuery, Java, TomCat, Servlets, JSP, REST, Spring Framework, Hibernate (JPA), MySQL, JDBC, HQL, JSTL, Apache Tiles, Apache Maven, AngularJS.
The web application that manages organizational structure for parent and child companies. Each company has two properties, they are company name and estimated annual earnings. There are two types of companies: 1 - main company, 2 - subsidiary company. The company can belong only to one company but can have a few child companies. 
Possibilities:
- the application allow a user to view / add / edit / delete any company;
- company name and estimated earnings be stored in database;
- showing companies tree.
Example:
Name | Company Estimated Earnings | Company Estimated Earnings + Child Companies (on all levels) Estimated Earnings.
- Company1 | 25K$ | 53K$
-- Company2 | 13K$ | 18K$
--- Company3 | 5K$
-- Company4 | 10K$
- Company5 | 10K$ | 30K$
-- Company6 | 15K$
-- Company7 | 5K$
