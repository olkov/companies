create database companies;
use companies;

INSERT INTO `company` (`idCompany`,`companyName`,`estimatedEarnings`,`parentId`) VALUES (1,'Company1',25,NULL);
INSERT INTO `company` (`idCompany`,`companyName`,`estimatedEarnings`,`parentId`) VALUES (2,'Company2',13,1);
INSERT INTO `company` (`idCompany`,`companyName`,`estimatedEarnings`,`parentId`) VALUES (3,'Company4',10,1);
INSERT INTO `company` (`idCompany`,`companyName`,`estimatedEarnings`,`parentId`) VALUES (4,'Company3',5,2);
