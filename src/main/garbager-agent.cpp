#include <stdlib.h>
#include <stdio.h>
#include <jvmti.h>


typedef struct {
	jvmtiEnv *jvmti;
} GlobalAgentData;

static GlobalAgentData *gdata;

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *jvm, char *options, void *reserved)
{
	printf("agent ready\n");
	jvmtiEnv *jvmti = NULL;
	
	jint
		result = jvm->GetEnv((void **)&jvmti, JVMTI_VERSION_1_1);
	if (result != JNI_OK) {
		printf("failed to get env\n");
	}

	gdata = (GlobalAgentData*)malloc(sizeof(GlobalAgentData));
	gdata->jvmti = jvmti;
	return JNI_OK;
}


extern "C"
JNIEXPORT void JNICALL Java_com_mycompany_forcegc_GCService_forceGarbageCollection(JNIEnv *env, jclass thisClass)
{	
	gdata->jvmti->ForceGarbageCollection();
	printf("gc forced\n");
}
