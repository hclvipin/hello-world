
dbFeDeploySrcList=findFiles(excludes: '', glob: '${vars.deploySource}\\?_?')

for (ii = 0; ii < dbFeDeploySrcList.size(); ii++) {
	if (dbFeDeploySrcList[ii].equalsIgnoreCase("fe_deploy")) {
		vars.put("feDeploySource", "$vars.deploySource\\" + dbFeDeploySrcList[ii])
		vars.put("feDeploySourceFolder", dbFeDeploySrcList[ii])
	}
	if (dbFeDeploySrcList[ii].equalsIgnoreCase("db_deploy")) {
		vars.put("dbDeploySource", "$vars.deploySource\\" + dbFeDeploySrcList[ii])
		vars.put("dbDeploySourceFolder", dbFeDeploySrcList[ii])
	}
}

in fe zip > 

glob: "${vars.feDeploySourceFolder}/**"

	
in db zip > 
	
glob: "${vars.dbDeploySourceFolder}/**"
	
