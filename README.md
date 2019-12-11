# AlmagServer

#List of articles

#URI	/articles/
#Method	GET – Gets list of articles with versions.
#Gets list of articles with version.

Errors
100 – Does Not Exist	Object does not exist


Article

URI	/articles/{id}/
Method	GET – Gets article by its id.
Gets article by its id.
Errors
100 – Does Not Exist	Object does not exist



Add rates
URI	/rates/
Method	POST – Adds rates of treating.
Adds rates of treating.
Request parameters
idPlan		Detailed plan’s id
Integer							Required
yearBirth		Patient’s year of birth
Integer							Required
gender		Patient’s gender
String							Required
rateBefore		State of health’s rate before treating.
Integer							Required
rateAfter		State of health’s rate after treating.
Integer							Required
Errors
100 – Does Not Exist	Object does not exist



Plans
URI	/plans/
Method	GET – Gets plans of treating.
Errors
100 – Does Not Exist	Object does not exist



Detailed plans
URI	/plans/detailed/
Method	GET – Gets detailed plans of treating.
Errors
100 – Does Not Exist	Object does not exist


