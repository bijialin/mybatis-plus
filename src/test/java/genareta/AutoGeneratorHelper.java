package genareta;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 自动生成映射工具类
 *
 *
 */
public class AutoGeneratorHelper {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/HdfsExplorer";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "111111";
	private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	private static final String PROJECT_PATH = "E:\\workspace\\exercise\\mybatis-plus";// 项目在硬盘上的基础路径
//	private static final String PROJECT_PATH = System.getProperty("user.dir");// 项目在硬盘上的基础路径

	@SuppressWarnings("unused")
	private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "\\src\\test\\resources\\generator\\templates\\";// 模板位置

	private static final String JAVA_PATH = "\\src\\main\\java"; // java文件路径
	@SuppressWarnings("unused")
	private static final String TEST_PATH = "\\src\\test\\java"; // test文件路径
	private static final String RESOURCES_PATH = "\\src\\main\\resources";// 资源文件路径

	public static final String BASE_RESOURCES = "src.main.resources";//

	public static final String BASE_PACKAGE = "com.nickbi.mybatisplus";// 项目基础包名称，根据自己公司的项目修改
	public static final String MODEL_PACKAGE = "model";// Model所在包
	public static final String MAPPER_PACKAGE = "dao";// Mapper所在包
	public static final String SERVICE_PACKAGE = "service";// Service所在包
	public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE+".impl";// ServiceImpl所在包
	public static final String CONTROLLER_PACKAGE = "web.api";// Controller所在包
	public static final String CORE_PACKAGE = BASE_PACKAGE + ".core";// Controller所在包

	public static final String MAPPER_XML = "\\mapper\\";// xml所在包
	public static final String MAPPER_VIEWS = "\\templates\\admin\\";// xml所在包

	private static final String AUTHOR = "nickBi";// @author

	/**
	 * <p>
	 * 测试 run 执行
	 * </p>
	 * generator
	 * <p>
	 * </p>
	 */
	public static void main(String[] args) {
		// 用来获取Mybatis-Plus.properties文件的配置信息
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();

		gc.setOutputDir(PROJECT_PATH + JAVA_PATH);// 输出位置

		gc.setFileOverride(true);
		gc.setActiveRecord(true);// 开启 activeRecord 模式
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
//		gc.setFileOverride(false);//是否覆盖已有文件
		gc.setFileOverride(true);//是否覆盖已有文件
		gc.setAuthor(AUTHOR);

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		// gc.setMapperName("%sDao");
		// gc.setXmlName("%sDao");
		gc.setServiceName("I%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setControllerName("%sController");
		
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert());
		dsc.setDriverName(JDBC_DIVER_CLASS_NAME);
		dsc.setUsername(JDBC_USERNAME);
		dsc.setPassword(JDBC_PASSWORD);
		dsc.setUrl(JDBC_URL);
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setTablePrefix(new String[] { "bmd_", "t_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		
//		String[] strs = new String[] { "t_upload_record" };
		String[] strs = new String[] { "t_logs" };
		strategy.setInclude(strs); // 需要生成的表
		strategy.setSuperControllerClass(CORE_PACKAGE + ".BaseController");
		// 字段名生成策略
		strategy.setDbColumnUnderline(false);
		strategy.setControllerMappingHyphenStyle(true);
		 
		
		mpg.setStrategy(strategy);

		// 关闭默认 xml 生成，调整生成 至 根目录
		TemplateConfig tc = new TemplateConfig();
//		tc.setController("/generator/templates/controller.java.vm");
//		tc.setService("/generator/templates/service.java.vm");
//		tc.setServiceImpl("/generator/templates/serviceImpl.java.vm");
		tc.setXml(null);
		mpg.setTemplate(tc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		 // 自定义list.ftl 生成
//        focList.add(new FileOutConfig("/generator/views/list.ftl.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称 
//	            return PROJECT_PATH + RESOURCES_PATH + MAPPER_VIEWS + tableInfo.getEntityName().toLowerCase() + File.separator +"list.ftl";
//                
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
        

		 // 自定义list.ftl 生成 
//       focList.add(new FileOutConfig("/generator/views/edit.ftl.vm") {
//           @Override
//           public String outputFile(TableInfo tableInfo) {
//               // 自定义输入文件名称  
//        	   
//        	   
//        	   
//        	   return PROJECT_PATH + RESOURCES_PATH + MAPPER_VIEWS + tableInfo.getEntityName().toLowerCase() + File.separator +"edit.ftl";
//           
//           
//           }
//       });
//       cfg.setFileOutConfigList(focList);
//       mpg.setCfg(cfg);

        //mapper
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {

			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return PROJECT_PATH + RESOURCES_PATH + MAPPER_XML + tableInfo.getMapperName() + ".xml";
			}
		});

		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 包配置
		PackageConfig pc = new PackageConfig();
		// pc.setModuleName("src");
		pc.setParent(BASE_PACKAGE);// 自定义包路径
		pc.setController(CONTROLLER_PACKAGE);// 这里是控制器包名，默认 web
		pc.setEntity(MODEL_PACKAGE);
		pc.setMapper(MAPPER_PACKAGE);
		// pc.setXml(null);
		pc.setService(SERVICE_PACKAGE);
		pc.setServiceImpl(SERVICE_IMPL_PACKAGE);
		mpg.setPackageInfo(pc);
		// 执行生成
		mpg.execute();

	}

}
