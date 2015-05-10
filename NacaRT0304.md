# What is Naca? -->[click here](Naca0201.md) #

# NacaRT - Configuration - NacaRT configuration file #

## NacaRT Configuration file ##

> A file, typically called nacaRT.cfg is used to give several execution parameters to the runtime that will execute the Cobol to Java transcoded applications.

> This is a XML file which structure is explained in this section.

> The parameters starting with '_' are ignored and can be ommited._

## Sample ##

```
 <conf
 	XSLFilePath="/opt/apps/pub2000/webapps/NacaTools/idea.xsl"
 	HelpXSLFilePath="/opt/apps/pub2000/webapps/NacaTools/help.xsl"
 	PSXSLFilePath="/opt/apps/pub2000/webapps/NacaTools/idea_ps.xsl"
 	ResourcePath="/opt/apps/pub2000/naca/Pub2000/Java/Resources/"
 	SequencerFactoryClass="nacaLib.misc.CProgramLoaderFactory"
 	XMLFrameFilePath="/opt/apps/pub2000/webapps/NacaTools/xmlPage.xml"
 	XMLFramePSFilePath="/opt/apps/pub2000/webapps/NacaTools/xmlPagePrintScreen.xml"
 	LogSettingsPathFile="/opt/apps/pub2000/webapps/NacaTools/WEB-INF/LogSettings.cfg"
 	_SemanticContextPathFile="/opt/apps/pub2000/webapps/NacaTools/WEB-INF/NacaContextDef.cfg"
 	_ScenarioFilePath="D:/Dev/naca/NacaTests/Scenarios/02PJD.xml"
 
 	ScenarioDir="/opt/apps/pub2000/scenarios/recording"
 	ScenarioOutputDir="/home/pub2000/output"
 
 	PreLoadAllProgramFromDir="false"
 	PreLoadAllProgramFromList="false"
 	KeepPreloadedProgramList="false"
 	PreLoadProgramFromList="D:/Dev/naca/nacaRT/idea/web/WEB-INF/ProgramList.xml"
 
 	_PreLoadAllProgramFromDir="false"
 	_SerializePreLoadedProgram="false"
 	_VarDefCatalogueSerilizationPath="D:/Dev/naca/pub2000/VarDefSerialization/"
 
 	EmulWebRootPath=""
 	UseProgramPool="true"
 	UseSQLStatementCache="true"
 
 	UseSQLObjectCache="true"
 	UseVarFillCache="true"
 
 	ManageVarDefCatalog="true"
 	CacheResourceFiles="true"
 
 	MaxSessionExecTime_ms="6000000"
 	HttpSessionMaxInactiveInterval_s="600000"
 
 	ApplicationClassPath="/opt/apps/pub2000/naca/Pub2000/bin"
 
 	_JarXMLFile="Pub2000Resources.zip"
 	JarFile="Pub2000.jar"
 	CanLoadJar="false"
 	CanLoadClass="true"
 
 	MaxSizeMemPoolCodeCache_Mb="32"
 	MaxSizeMemPoolPermGen_Mb="180"
 
 	ServerName="NACT"
 	LDAPServer="publigroupe.net"
 	LDAPRootOU="OU=FUTUR_PUBLIGROUPE,DC=Publigroupe,DC=net"
 
 	AppLauncherConfig="/opt/apps/pub2000/webapps/NacaTools/WEB-INF/CustomAppLauncher.cfg"
 >
 
 	<SequencerConfig
 		TransIDMappingFilePath="/opt/apps/pub2000/naca/Pub2000/Java/TransIDMapping.xml"
 		TranslationFilePath="/opt/apps/pub2000/naca/Pub2000/Java/Translations.xml">
 		<StartPrograms>
 			<_Program name="RS7AS70" delaySeconds="15"/>
 		</StartPrograms>
 
 		<MailConfig
 			addressFrom="alert-nacaTest@consultas.ch"
 			smtpServer="smtp.intra.consultas.ch"
 			title="NACA-Pub2000-LinuxTest">
 			<addressTo  email="dbarman@consultas.ch"/>
 			<addressTo  email="scharton@consultas.ch"/>
 			<addressTo  email="pjditscheid@consultas.ch"/>
 		</MailConfig>
 
 		<CESMConfig
 			StartTransID="INIR"
 			StartCommandCode="XCTL"
 			HelpCenterClassName="pub2000Utils.help.HelpCenter"
 			_DataRecordPath="D:\Dev\NacaTests\Scenarios\"
 			_DataRecordFilePattern="RS01-INIT-">
 			<Config
 				StartBatchTest="true"
 				StartBatchLinux="false"
 				StartBatchFTPUrl="mvs.consultas.ch"
 				StartBatchFTPUser="C930NAC"
 				StartBatchFTPPassword="NACA"
 				StartBatchFTPSiteCommand="xlate=iso8859;FILETYPE=JES"
 			/>
 		</CESMConfig>
 
 		<SQLConfig
 			dburl="jdbc:db2://10.100.100.100:3333/LSNSDB2:"
 			dbuser="C930NAC"
 			dbpassword="NACA"
 			_CryptKey="ZORGLUB"
 			_CryptedDbpassword="73347c32972c153c"
 			dbConnectionUrlOptionalParams="keepDynamic=yes;clientProgramName=$FoundPoolName;clientWorkstation=$RequestedPoolName;"
 			dbenvironment="NACT"
 			driverClass="com.ibm.db2.jcc.DB2Driver"
 			CloseCursorOnCommit="true"
 			AutoCommit="false"
 			NbLoopWaitFreeConnection="60"
 			TimeWaitFreeConnection_ms="1000"
 			validationQuery="select * from nact.vi0392">
 			<Pools>
 				<Pool
                                       TransactionId=""
                                       MaxConnection="50"
                                       TimeBeforeRemoveConnection_ms="600000"
                                       UseExplain="false
                                       "/>
 			</Pools>
 		</SQLConfig>
 	</SequencerConfig>
 </conf>
```