package com.yihengliu.demo.common.model;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;

/**
 * Jfinl Model生成类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-31 上午10:06
 **/
public class _JFinalDemoGenerator {
    public static DataSource getDataSource() {
        PropKit.use("config.properties");
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        druidPlugin.start();
        return druidPlugin.getDataSource();
    }

    public static void main(String[] args) {
        String baseModelPackageName = "com.yihengliu.demo.common.model.base";
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/com/yihengliu/demo/common/model/base";

        String modelPackageName = "com.yihengliu.demo.common.model";
        String modelOutputDir = baseModelOutputDir + "/..";

        Generator generator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
        // 设置不需要生成的表名
        generator.addExcludedTable("");
        generator.setGenerateDaoInModel(true);
        generator.setGenerateChainSetter(true);
        generator.setGenerateDataDictionary(false);
        generator.setRemovedTableNamePrefixes("t_");
        generator.setGenerateDataDictionary(true);
        generator.generate();
    }
}