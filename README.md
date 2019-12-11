# AlmagServer

##List of articles

|URI   | /articles/  |
| ------------ | ------------ |
| Method  | GET – Gets list of articles with versions.  |

Gets list of articles with version.

###Errors

100 – Does Not Exist	Object does not exist


##Article

|URI   | /articles/{id}/  |
| ------------ | ------------ |
| Method  | GET – Gets article by its id.  |

Gets article by its id.

###Errors

|100 – Does Not Exist   | Object does not exist  |
| ------------ | ------------ |



##Add rates

|URI   | /rates/  |
| ------------ | ------------ |
|Method   | POST – Adds rates of treating.  |

Adds rates of treating.

###Request parameters

|idPlan [Integer]  | Detailed plan's id[Required]  |
| ------------ | ------------ |
|yearBirth [Integer] |Patient’s year of birth[Required]  |
|gender[String]   |Patient’s gender[Required]   |
|rateBefore[Integer]   |State of health’s rate before treating.[Required]   |
|rateAfter[Integer]   |State of health’s rate after treating.[Required]  |

###Errors

|100 – Does Not Exist   | Object does not exist  |
| ------------ | ------------ |



##Plans

|URI   | /plans/  |
| ------------ | ------------ |
|Method   | GET – Gets plans of treating.  |

###Errors

|100 – Does Not Exist   | Object does not exist  |
| ------------ | ------------ |



##Detailed plans

|URI   | /plans/detailed/  |
| ------------ | ------------ |
|Method   | GET – Gets detailed plans of treating.  |

###Errors

|100 – Does Not Exist   | Object does not exist  |
| ------------ | ------------ |


