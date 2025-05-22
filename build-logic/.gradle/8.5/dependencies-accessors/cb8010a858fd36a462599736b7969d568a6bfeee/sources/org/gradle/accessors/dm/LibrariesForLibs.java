package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final DetektLibraryAccessors laccForDetektLibraryAccessors = new DetektLibraryAccessors(owner);
    private final FirebaseLibraryAccessors laccForFirebaseLibraryAccessors = new FirebaseLibraryAccessors(owner);
    private final KoinLibraryAccessors laccForKoinLibraryAccessors = new KoinLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final MockkLibraryAccessors laccForMockkLibraryAccessors = new MockkLibraryAccessors(owner);
    private final MoshiLibraryAccessors laccForMoshiLibraryAccessors = new MoshiLibraryAccessors(owner);
    private final RetrofitLibraryAccessors laccForRetrofitLibraryAccessors = new RetrofitLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for coil (io.coil-kt:coil-compose)
     * with versionRef 'coilVersion'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCoil() {
            return create("coil");
    }

        /**
         * Creates a dependency provider for junit (junit:junit)
     * with versionRef 'junitVersion'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit");
    }

        /**
         * Creates a dependency provider for lottie (com.airbnb.android:lottie)
     * with versionRef 'lottieVersion'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLottie() {
            return create("lottie");
    }

        /**
         * Creates a dependency provider for material (com.google.android.material:material)
     * with versionRef 'materialVersion'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() {
            return create("material");
    }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() {
        return laccForAndroidLibraryAccessors;
    }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at compose
     */
    public ComposeLibraryAccessors getCompose() {
        return laccForComposeLibraryAccessors;
    }

    /**
     * Returns the group of libraries at detekt
     */
    public DetektLibraryAccessors getDetekt() {
        return laccForDetektLibraryAccessors;
    }

    /**
     * Returns the group of libraries at firebase
     */
    public FirebaseLibraryAccessors getFirebase() {
        return laccForFirebaseLibraryAccessors;
    }

    /**
     * Returns the group of libraries at koin
     */
    public KoinLibraryAccessors getKoin() {
        return laccForKoinLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at mockk
     */
    public MockkLibraryAccessors getMockk() {
        return laccForMockkLibraryAccessors;
    }

    /**
     * Returns the group of libraries at moshi
     */
    public MoshiLibraryAccessors getMoshi() {
        return laccForMoshiLibraryAccessors;
    }

    /**
     * Returns the group of libraries at retrofit
     */
    public RetrofitLibraryAccessors getRetrofit() {
        return laccForRetrofitLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {
        private final AndroidGradleLibraryAccessors laccForAndroidGradleLibraryAccessors = new AndroidGradleLibraryAccessors(owner);

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at android.gradle
         */
        public AndroidGradleLibraryAccessors getGradle() {
            return laccForAndroidGradleLibraryAccessors;
        }

    }

    public static class AndroidGradleLibraryAccessors extends SubDependencyFactory {

        public AndroidGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.android.tools.build:gradle)
         * with versionRef 'androidGradleVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("android.gradle.plugin");
        }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxAnnotationLibraryAccessors laccForAndroidxAnnotationLibraryAccessors = new AndroidxAnnotationLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleRuntimeLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
         * with versionRef 'appcompatVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() {
                return create("androidx.appcompat");
        }

            /**
             * Creates a dependency provider for runtime (androidx.compose.runtime:runtime)
         * with versionRef 'runtimeVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() {
                return create("androidx.runtime");
        }

        /**
         * Returns the group of libraries at androidx.annotation
         */
        public AndroidxAnnotationLibraryAccessors getAnnotation() {
            return laccForAndroidxAnnotationLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() {
            return laccForAndroidxCoreLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.lifecycleRuntime
         */
        public AndroidxLifecycleRuntimeLibraryAccessors getLifecycleRuntime() {
            return laccForAndroidxLifecycleRuntimeLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() {
            return laccForAndroidxTestLibraryAccessors;
        }

    }

    public static class AndroidxAnnotationLibraryAccessors extends SubDependencyFactory {

        public AndroidxAnnotationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jvm (androidx.annotation:annotation-jvm)
         * with versionRef 'annotationJvmVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJvm() {
                return create("androidx.annotation.jvm");
        }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
         * with versionRef 'coreKtxVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.core.ktx");
        }

    }

    public static class AndroidxLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-runtime-ktx)
         * with versionRef 'lifecycleRuntimeKtxVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.lifecycleRuntime.ktx");
        }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for espresso (androidx.test.espresso:espresso-core)
         * with versionRef 'espressoVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEspresso() {
                return create("androidx.test.espresso");
        }

            /**
             * Creates a dependency provider for ext (androidx.test.ext:junit)
         * with versionRef 'androidxTestExtVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExt() {
                return create("androidx.test.ext");
        }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {
        private final ComposeMaterialLibraryAccessors laccForComposeMaterialLibraryAccessors = new ComposeMaterialLibraryAccessors(owner);
        private final ComposeTestLibraryAccessors laccForComposeTestLibraryAccessors = new ComposeTestLibraryAccessors(owner);
        private final ComposeToolingLibraryAccessors laccForComposeToolingLibraryAccessors = new ComposeToolingLibraryAccessors(owner);
        private final ComposeUiLibraryAccessors laccForComposeUiLibraryAccessors = new ComposeUiLibraryAccessors(owner);

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bom (androidx.compose:compose-bom)
         * with versionRef 'composeBomVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() {
                return create("compose.bom");
        }

            /**
             * Creates a dependency provider for navigation (androidx.navigation:navigation-compose)
         * with versionRef 'navigationComposeVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNavigation() {
                return create("compose.navigation");
        }

        /**
         * Returns the group of libraries at compose.material
         */
        public ComposeMaterialLibraryAccessors getMaterial() {
            return laccForComposeMaterialLibraryAccessors;
        }

        /**
         * Returns the group of libraries at compose.test
         */
        public ComposeTestLibraryAccessors getTest() {
            return laccForComposeTestLibraryAccessors;
        }

        /**
         * Returns the group of libraries at compose.tooling
         */
        public ComposeToolingLibraryAccessors getTooling() {
            return laccForComposeToolingLibraryAccessors;
        }

        /**
         * Returns the group of libraries at compose.ui
         */
        public ComposeUiLibraryAccessors getUi() {
            return laccForComposeUiLibraryAccessors;
        }

    }

    public static class ComposeMaterialLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final ComposeMaterialWindowLibraryAccessors laccForComposeMaterialWindowLibraryAccessors = new ComposeMaterialWindowLibraryAccessors(owner);

        public ComposeMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for material (androidx.compose.material3:material3)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("compose.material");
        }

        /**
         * Returns the group of libraries at compose.material.window
         */
        public ComposeMaterialWindowLibraryAccessors getWindow() {
            return laccForComposeMaterialWindowLibraryAccessors;
        }

    }

    public static class ComposeMaterialWindowLibraryAccessors extends SubDependencyFactory {

        public ComposeMaterialWindowLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for size (androidx.compose.material3:material3-window-size-class)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSize() {
                return create("compose.material.window.size");
        }

    }

    public static class ComposeTestLibraryAccessors extends SubDependencyFactory {

        public ComposeTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for manifest (androidx.compose.ui:ui-test-manifest)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getManifest() {
                return create("compose.test.manifest");
        }

    }

    public static class ComposeToolingLibraryAccessors extends SubDependencyFactory {

        public ComposeToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for preview (androidx.compose.ui:ui-tooling-preview)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreview() {
                return create("compose.tooling.preview");
        }

    }

    public static class ComposeUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("compose.ui");
        }

            /**
             * Creates a dependency provider for test (androidx.compose.ui:ui-test-junit4)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("compose.ui.test");
        }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTooling() {
                return create("compose.ui.tooling");
        }

    }

    public static class DetektLibraryAccessors extends SubDependencyFactory {
        private final DetektGradleLibraryAccessors laccForDetektGradleLibraryAccessors = new DetektGradleLibraryAccessors(owner);

        public DetektLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at detekt.gradle
         */
        public DetektGradleLibraryAccessors getGradle() {
            return laccForDetektGradleLibraryAccessors;
        }

    }

    public static class DetektGradleLibraryAccessors extends SubDependencyFactory {

        public DetektGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (io.gitlab.arturbosch.detekt:detekt-gradle-plugin)
         * with versionRef 'detektVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("detekt.gradle.plugin");
        }

    }

    public static class FirebaseLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public FirebaseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for firebase (com.google.gms:google-services)
         * with versionRef 'firebaseVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("firebase");
        }

            /**
             * Creates a dependency provider for analytics (com.google.firebase:firebase-analytics-ktx)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAnalytics() {
                return create("firebase.analytics");
        }

            /**
             * Creates a dependency provider for bom (com.google.firebase:firebase-bom)
         * with versionRef 'firebaseBomVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() {
                return create("firebase.bom");
        }

    }

    public static class KoinLibraryAccessors extends SubDependencyFactory {
        private final KoinAndroidxLibraryAccessors laccForKoinAndroidxLibraryAccessors = new KoinAndroidxLibraryAccessors(owner);
        private final KoinKspLibraryAccessors laccForKoinKspLibraryAccessors = new KoinKspLibraryAccessors(owner);

        public KoinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (io.insert-koin:koin-android)
         * with versionRef 'koinVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("koin.android");
        }

            /**
             * Creates a dependency provider for annotations (io.insert-koin:koin-annotations)
         * with versionRef 'koinAnnotationsVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAnnotations() {
                return create("koin.annotations");
        }

            /**
             * Creates a dependency provider for core (io.insert-koin:koin-core)
         * with versionRef 'koinVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("koin.core");
        }

            /**
             * Creates a dependency provider for test (io.insert-koin:koin-test)
         * with versionRef 'koinTestVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("koin.test");
        }

        /**
         * Returns the group of libraries at koin.androidx
         */
        public KoinAndroidxLibraryAccessors getAndroidx() {
            return laccForKoinAndroidxLibraryAccessors;
        }

        /**
         * Returns the group of libraries at koin.ksp
         */
        public KoinKspLibraryAccessors getKsp() {
            return laccForKoinKspLibraryAccessors;
        }

    }

    public static class KoinAndroidxLibraryAccessors extends SubDependencyFactory {

        public KoinAndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (io.insert-koin:koin-androidx-compose)
         * with versionRef 'koinAndroidxComposeVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("koin.androidx.compose");
        }

    }

    public static class KoinKspLibraryAccessors extends SubDependencyFactory {

        public KoinKspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compiler (io.insert-koin:koin-ksp-compiler)
         * with versionRef 'koinAnnotationsVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() {
                return create("koin.ksp.compiler");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinGradleLibraryAccessors laccForKotlinGradleLibraryAccessors = new KotlinGradleLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlin:kotlin-test-junit)
         * with versionRef 'kotlinTestVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("kotlin.test");
        }

        /**
         * Returns the group of libraries at kotlin.gradle
         */
        public KotlinGradleLibraryAccessors getGradle() {
            return laccForKotlinGradleLibraryAccessors;
        }

    }

    public static class KotlinGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.kotlin:kotlin-gradle-plugin)
         * with versionRef 'kotlinVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("kotlin.gradle.plugin");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.coroutines
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() {
            return laccForKotlinxCoroutinesLibraryAccessors;
        }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlinx:kotlinx-coroutines-test)
         * with versionRef 'coroutinesVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("kotlinx.coroutines.test");
        }

    }

    public static class MockkLibraryAccessors extends SubDependencyFactory {

        public MockkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for agent (io.mockk:mockk-agent-jvm)
         * with versionRef 'mockkVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAgent() {
                return create("mockk.agent");
        }

            /**
             * Creates a dependency provider for android (io.mockk:mockk-android)
         * with versionRef 'mockkVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("mockk.android");
        }

    }

    public static class MoshiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public MoshiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for moshi (com.squareup.moshi:moshi)
         * with versionRef 'moshiVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("moshi");
        }

            /**
             * Creates a dependency provider for adapters (com.squareup.moshi:moshi-adapters)
         * with versionRef 'moshiVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAdapters() {
                return create("moshi.adapters");
        }

            /**
             * Creates a dependency provider for kotlin (com.squareup.moshi:moshi-kotlin)
         * with versionRef 'moshiVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKotlin() {
                return create("moshi.kotlin");
        }

            /**
             * Creates a dependency provider for ksp (com.squareup.moshi:moshi-kotlin-codegen)
         * with versionRef 'moshiVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKsp() {
                return create("moshi.ksp");
        }

    }

    public static class RetrofitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public RetrofitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for retrofit (com.squareup.retrofit2:retrofit)
         * with versionRef 'retrofitVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("retrofit");
        }

            /**
             * Creates a dependency provider for moshi (com.squareup.retrofit2:converter-moshi)
         * with versionRef 'retrofitVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMoshi() {
                return create("retrofit.moshi");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidGradleVersion (8.4.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidGradleVersion() { return getVersion("androidGradleVersion"); }

            /**
             * Returns the version associated to this alias: androidxTestExtVersion (1.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidxTestExtVersion() { return getVersion("androidxTestExtVersion"); }

            /**
             * Returns the version associated to this alias: annotationJvmVersion (1.9.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAnnotationJvmVersion() { return getVersion("annotationJvmVersion"); }

            /**
             * Returns the version associated to this alias: appcompatVersion (1.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppcompatVersion() { return getVersion("appcompatVersion"); }

            /**
             * Returns the version associated to this alias: coilVersion (2.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoilVersion() { return getVersion("coilVersion"); }

            /**
             * Returns the version associated to this alias: composeBomVersion (2025.04.00)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getComposeBomVersion() { return getVersion("composeBomVersion"); }

            /**
             * Returns the version associated to this alias: composeVersion (1.5.11)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getComposeVersion() { return getVersion("composeVersion"); }

            /**
             * Returns the version associated to this alias: coreKtxVersion (1.16.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoreKtxVersion() { return getVersion("coreKtxVersion"); }

            /**
             * Returns the version associated to this alias: coroutinesVersion (1.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutinesVersion() { return getVersion("coroutinesVersion"); }

            /**
             * Returns the version associated to this alias: detektVersion (1.22.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDetektVersion() { return getVersion("detektVersion"); }

            /**
             * Returns the version associated to this alias: espressoVersion (3.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEspressoVersion() { return getVersion("espressoVersion"); }

            /**
             * Returns the version associated to this alias: firebaseBomVersion (33.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFirebaseBomVersion() { return getVersion("firebaseBomVersion"); }

            /**
             * Returns the version associated to this alias: firebaseVersion (4.4.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFirebaseVersion() { return getVersion("firebaseVersion"); }

            /**
             * Returns the version associated to this alias: jacocoVersion (0.8.9)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJacocoVersion() { return getVersion("jacocoVersion"); }

            /**
             * Returns the version associated to this alias: junitVersion (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunitVersion() { return getVersion("junitVersion"); }

            /**
             * Returns the version associated to this alias: koinAndroidxComposeVersion (3.5.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoinAndroidxComposeVersion() { return getVersion("koinAndroidxComposeVersion"); }

            /**
             * Returns the version associated to this alias: koinAnnotationsVersion (1.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoinAnnotationsVersion() { return getVersion("koinAnnotationsVersion"); }

            /**
             * Returns the version associated to this alias: koinTestVersion (3.5.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoinTestVersion() { return getVersion("koinTestVersion"); }

            /**
             * Returns the version associated to this alias: koinVersion (3.5.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoinVersion() { return getVersion("koinVersion"); }

            /**
             * Returns the version associated to this alias: kotlinTestVersion (1.9.22)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinTestVersion() { return getVersion("kotlinTestVersion"); }

            /**
             * Returns the version associated to this alias: kotlinVersion (2.0.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinVersion() { return getVersion("kotlinVersion"); }

            /**
             * Returns the version associated to this alias: kspVersion (2.0.21-1.0.27)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKspVersion() { return getVersion("kspVersion"); }

            /**
             * Returns the version associated to this alias: lifecycleRuntimeKtxVersion (2.8.7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycleRuntimeKtxVersion() { return getVersion("lifecycleRuntimeKtxVersion"); }

            /**
             * Returns the version associated to this alias: lottieVersion (3.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLottieVersion() { return getVersion("lottieVersion"); }

            /**
             * Returns the version associated to this alias: materialVersion (1.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterialVersion() { return getVersion("materialVersion"); }

            /**
             * Returns the version associated to this alias: mockkVersion (1.13.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMockkVersion() { return getVersion("mockkVersion"); }

            /**
             * Returns the version associated to this alias: moshiVersion (1.15.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMoshiVersion() { return getVersion("moshiVersion"); }

            /**
             * Returns the version associated to this alias: navigationComposeVersion (2.8.9)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNavigationComposeVersion() { return getVersion("navigationComposeVersion"); }

            /**
             * Returns the version associated to this alias: retrofitVersion (2.11.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRetrofitVersion() { return getVersion("retrofitVersion"); }

            /**
             * Returns the version associated to this alias: runtimeVersion (1.8.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRuntimeVersion() { return getVersion("runtimeVersion"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final ComposeBundleAccessors baccForComposeBundleAccessors = new ComposeBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Returns the group of bundles at bundles.compose
         */
        public ComposeBundleAccessors getCompose() {
            return baccForComposeBundleAccessors;
        }

    }

    public static class ComposeBundleAccessors extends BundleFactory {
        private final ComposeBundleBundleAccessors baccForComposeBundleBundleAccessors = new ComposeBundleBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ComposeBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Returns the group of bundles at bundles.compose.bundle
         */
        public ComposeBundleBundleAccessors getBundle() {
            return baccForComposeBundleBundleAccessors;
        }

    }

    public static class ComposeBundleBundleAccessors extends BundleFactory {

        public ComposeBundleBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for compose.bundle.ui which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.compose.ui:ui</li>
             *    <li>androidx.compose.material3:material3</li>
             *    <li>androidx.compose.material3:material3-window-size-class</li>
             *    <li>androidx.compose.ui:ui-tooling-preview</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getUi() {
                return createBundle("compose.bundle.ui");
            }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors paccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final ComposePluginAccessors paccForComposePluginAccessors = new ComposePluginAccessors(providers, config);
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for ksp to the plugin id 'com.google.devtools.ksp'
             * with versionRef 'kspVersion'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKsp() { return createPlugin("ksp"); }

        /**
         * Returns the group of plugins at plugins.android
         */
        public AndroidPluginAccessors getAndroid() {
            return paccForAndroidPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.compose
         */
        public ComposePluginAccessors getCompose() {
            return paccForComposePluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for android.application to the plugin id 'com.android.application'
             * with versionRef 'androidGradleVersion'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

            /**
             * Creates a plugin provider for android.library to the plugin id 'com.android.library'
             * with versionRef 'androidGradleVersion'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("android.library"); }

    }

    public static class ComposePluginAccessors extends PluginFactory {

        public ComposePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for compose.compiler to the plugin id 'org.jetbrains.kotlin.plugin.compose'
             * with versionRef 'kotlinVersion'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getCompiler() { return createPlugin("compose.compiler"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.android to the plugin id 'org.jetbrains.kotlin.android'
             * with versionRef 'kotlinVersion'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("kotlin.android"); }

    }

}
