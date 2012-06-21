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

1. SmartDictionary delegates to Translator for translations. Start by adding SmartDictionaryTest with "shouldLookUpWords" method.
1. "Only mock types you own", create Translator implementation that wraps the OnlineTranslator
1. remembers the translation input and translation result via the History. Start by adding "shouldMaintainHistory" test.
1. Use test constructor for 'boring' setup
1. Use @Mock, @InjectMocks annotations and the MocktioJUnitRunner

1. If History throws CannotUpdateHistory runtime exception. SmartDictionary should just warn in such case and not fail explosively. Start by adding "shouldIgnoreUnavailableHistory" test.

1. Modeling: use TranslationRequest in Translator
 * Implement equals() to facilitate argument matching

1. TranslationRequest contains requestDate
 * write simple unit test for request date (TranslationRequestTest)
 * change the equals to contain the requestDate
 * Use the argument matcher
 * get rid of equals

1. History should use the TranslationRequest
 * reuse argument matchers
 * improve error message when args don't match

1. More Modeling: use TranslationResult in Translator
 * History should remember the TranslationResult
 * Use relaxed argument matchers in safe history test for all args
 * Use equals, discuss an argument matcher
 * Use argument captor
 * What's the alternative apart from matcher, captor and equals()?

1. Retry the translation attempts up to X times. Start with "shouldRetryTranslations" test.

 * After implementing it in SmartDictionary, model the RetryingTranslator and move the unit tests accordingly
 * Refactor the tests
 * Don't forget about happy and unhappy tests for the feature
 * make the exceptions carry information about the failed attempts

1. Break TranslationHistory operation into 2: translation attempt and translation completed. Start with "shouldTrackTranslationAttempts" test for the RetryingTranslatorTest
 * Explain the kinds of verification modes (atLeastOnce(), atLeast, atMost, never())
 * What do we do with the CannotUpdateHistory? Create SafeHistory implementation and move tests accordingly
 * refactor to SafeHistory to avoid try-catches in the SmartDictionary

1. Demonstrate all tests work if SmartDictionary uses the RetryingTranslator and SafeHistory directly. Is it a good idea?
1. Introduce dictionary factory - your dependency injection infrastructure
1. Refactor packages: model, app, dictionary, history, translator

1. Only use TranslationHistory if the keepHistory is enabled for SmartDictionary. Start with "shouldHistoryUpdatesBeConfigurable" test for SafeHistoryTest.
 * Use never() to make sure the interactions didn't happen
 * Refactor to use verifyNoMoreInteractions()

1. TranslationResult contains the TranslationRequest
 * DefaultTranslator (the anti-corruption layer) needs tests
 * Use spy() to test if DefaultTranslator delegates and creates correct result
 * explain the difference between mockito spy and mockito mock

1. Refactor to separate packages: api, history, translators