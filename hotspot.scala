import com.forcewave.gs.api.layer.GSLayerRDD;
import com.forcewave.gs.api.layer.GSStatOperation;
import com.forcewave.gs.manager.SparkManager;
//import org.apache.spark.api.java.JavaSparkContext;
//var jsc = new JavaSparkContext(sc);
var spark_manager = new SparkManager("test-spark-job", "192.168.0.222", 54555, 5*1024);
var rdd = new GSLayerRDD(spark_manager, "work",12)
var intersection_res_rdd = GSStatOperation.Hotspot(rdd, "pop", 0, 0, 100)
var cnt = intersection_res_rdd.getLayerRdd().count()

var htmrres = "htmrres";

intersection_res_rdd.saveToHDFS(htmrres);
import com.forcewave.gs.api.index.GSIndexCreator;
var idx_creator_distance = new GSIndexCreator(spark_manager, htmrres, 12);
idx_creator_distance.creatIndex();

