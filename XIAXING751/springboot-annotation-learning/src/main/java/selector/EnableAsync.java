package selector;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;
import org.springframework.scheduling.annotation.ProxyAsyncConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AsyncConfigurationSelector.class)
public @interface EnableAsync {
	public class AsyncConfigurationSelector extends AdviceModeImportSelector<EnableAsync> {
		private static final String ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME = "org.springframework.scheduling.aspectj.AspectJAsyncConfiguration";

		/**
		 * * {@inheritDoc} * * @return {@link ProxyAsyncConfiguration} or
		 * {@code AspectJAsyncConfiguration} * for {@code PROXY} and {@code ASPECTJ}
		 * values of * {@link EnableAsync#mode()}, respectively
		 */
		@Override
		public String[] selectImports(AdviceMode adviceMode) {
			switch (adviceMode) {
			case PROXY:
				return new String[] { ProxyAsyncConfiguration.class.getName() };
			case ASPECTJ:
				return new String[] { ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME };
			default:
				return null;
			}
		}
	}
}