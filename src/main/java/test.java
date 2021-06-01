
dbFeDeploySrcList=findFiles(excludes: '', glob: '${vars.deploySource}\\?_?eploy')

for (ii = 0; ii < dbFeDeploySrcList.size(); ii++) {
	if (feDeploySrcList[ii].equalsIgnoreCase("fe_deploy")) {
		vars.put("feDeploySource", "$vars.deploySource\\" + dbFeDeploySrcList[ii])
	}
	if (dbFeDeploySrcList[ii].equalsIgnoreCase("db_deploy")) {
		vars.put("dbDeploySource", "$vars.deploySource\\" + dbFeDeploySrcList[ii])
		break
	}
}
