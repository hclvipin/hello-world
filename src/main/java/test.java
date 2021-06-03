
dbFeDeploySrcList=findFiles(excludes: '', glob: '${vars.deploySource}\\?_?')

// for (ii = 0; ii < dbFeDeploySrcList.size(); ii++) {
// 	if (dbFeDeploySrcList[ii].equalsIgnoreCase("fe_deploy")) {
// 		vars.put("feDeploySource", "$vars.deploySource\\" + dbFeDeploySrcList[ii])
// 		vars.put("feDeploySourceFolder", dbFeDeploySrcList[ii])
// 	}
// 	if (dbFeDeploySrcList[ii].equalsIgnoreCase("db_deploy")) {
// 		vars.put("dbDeploySource", "$vars.deploySource\\" + dbFeDeploySrcList[ii])
// 		vars.put("dbDeploySourceFolder", dbFeDeploySrcList[ii])
// 	}
// }

dbFeDeploySrcList.each { _file ->
	if ("${_file.name}".equalsIgnoreCase("fe_deploy")) {
		vars.put("feDeploySource", "$vars.deploySource\\" + "${_file.name}")
		vars.put("feDeploySourceFolder", "${_file.name}")
	}
	if ("${_file.name}".equalsIgnoreCase("db_deploy")) {
		vars.put("dbDeploySource", "$vars.deploySource\\" + "${_file.name}")
		vars.put("dbDeploySourceFolder", "${_file.name}")
	}
}



in fe zip > 

glob: "${vars.feDeploySourceFolder}/**"

	
in db zip > 
	
glob: "${vars.dbDeploySourceFolder}/**"
	
