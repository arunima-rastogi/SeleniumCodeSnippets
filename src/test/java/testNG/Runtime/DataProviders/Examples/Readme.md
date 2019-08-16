## Runtime Dataprovider configuration

update  "testngDPatFly.xml" with Annotation provider as follow:

1. 		<listener
			class-name="testNG.Runtime.DataProviders.Examples.MyIAnnotationTransformer"></listener>
	    </listeners>

2.     	<listener
		   class-name="testNG.Runtime.DataProviders.Examples.FactoryAnnotationTransformerListener"></listener>
	    </listeners>
	    
3. 		<listener
			class-name="testNG.Runtime.DataProviders.Examples.DataProviderAnnotationTransformerListener"></listener>
	    </listeners>