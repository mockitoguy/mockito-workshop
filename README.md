# Workshop prerequisites

1. jdk 1.6 installed
1. eclipse or idea installed
1. git installed

# Workshop instructions

1. git clone http://github.com/szczepiq/mockito-workshop.git
1. alternatively, if don't have git, download (1.5 MB): https://github.com/szczepiq/mockito-workshop/zipball/master
1. Import the project into your favorite IDE (that is: eclipse or IntelliJ :)
1. Make sure the project builds & compiles in your IDE
1. The instructor will start live-coding the exercises, please follow

# Workshop stories

Below stories are more like 'notes'. Once we get to work on the together things will get clear :)

1. SmartDictionary delegates to Translator for translations. Start by adding "shouldLookUpWords" test.
1. "Only mock types you own", create Translator implementation that wraps the OnlineTranslator
1. remembers the translation input and translation result via the History. Start by adding "shouldMaintainHistory" test.
1. Use test constructor for 'boring' setup
1. Use @Mock, @InjectMocks annotations and the MocktioJUnitRunner

1. If History throws CannotUpdateHistory runtime exception. SmartDictionary should just warn in such case and not fail explosively. Start by adding "shouldIgnoreUnavailableHistory" test.
1. Consider alternative implementations: tweaking SmartDictionary or decorating the History

1. Modeling: use TranslationRequest in Translator
 * Implement equals() to facilitate argument matching
 * The problem of 2 failing tests when translation feature is broken.
 * Use argument matcher
 * Argument matcher can be used for stubbing or verification

1. More Modeling: use TranslationResult in Translator
 * History should remember the TranslationResult
 * Use argument matcher
 * Demonstrate usefulness of toString() when arg matching fails
 * Use argument captor
 * What's the alternative apart from matcher, captor and equals() ?
 * Use relaxed arg matching to improve tests maintainability

1. Store the current date with TranslationRequest. Explain the effect on the equals(). Demonstrate the usefulness of the arg matcher

1. Retry the translation attempts up to X times. Start with "shouldRetryTranslations" test.
 * Model RetryingTranslator and move the unit tests accordingly
 * Use RetryingTranslator directly in SmartDictionary and show that all tests still pass
 * Don't forget about happy and unhappy tests for the feature

1. Break TranslationHistory operation into 2: translation attempt and translation completed. Start with "shouldTrackTranslationAttempts" test for the RetryingTranslatorTest
 * Explain the kinds of verification modes (atLeastOnce(), atLeast, atMost, never())
 * What do we do with the CannotUpdateHistory? Create SafeHistory implementation and move tests accordingly
 * Explain verifyZeroInteractions and ignoreStubs()

1. Demonstrate all tests work if SmartDictionary uses the RetryingTranslator and SafeHistory directly. Is it a good idea?
1. Introduce dictionary factory - you dependency injection infrastructure

1. Only use TranslationHistory if the keepHistory is enabled for SmartDictionary. Start with "shouldHistoryUpdatesBeConfigurable" test for SafeHistoryTest.
 * Use never() to make sure the interactions didn't happen
 * Refactor to use verifyNoMoreInteractions()

1. TranslationResult contains the TranslationRequest
 * Fail immediately if returned TranslationResult does not have sent in TranslationRequest.
 * Refactor to a separate object: ValidatingTranslator

1. Refactor to separate packages: api, history, translators