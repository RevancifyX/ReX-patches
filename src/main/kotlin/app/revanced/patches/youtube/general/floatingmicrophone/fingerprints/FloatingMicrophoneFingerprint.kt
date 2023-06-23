package app.revanced.patches.youtube.general.floatingmicrophone.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import app.revanced.patches.youtube.utils.resourceid.patch.SharedResourceIdPatch.Companion.Fab
import app.revanced.util.bytecode.isWideLiteralExists
import org.jf.dexlib2.Opcode

object FloatingMicrophoneFingerprint : MethodFingerprint(
    opcodes = listOf(
        Opcode.IGET_BOOLEAN,
        Opcode.IF_EQZ,
        Opcode.RETURN_VOID
    ),
    customFingerprint = { methodDef, _ -> methodDef.isWideLiteralExists(Fab) }
)